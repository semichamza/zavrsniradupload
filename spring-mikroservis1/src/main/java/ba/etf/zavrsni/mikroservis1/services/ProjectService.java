package ba.etf.zavrsni.mikroservis1.services;

import ba.etf.zavrsni.mikroservis1.domain.Project;
import ba.etf.zavrsni.mikroservis1.domain.Skill;
import ba.etf.zavrsni.mikroservis1.repositories.ProjectRepository;
import ba.etf.zavrsni.mikroservis1.repositories.SkillRepository;
import ba.etf.zavrsni.mikroservis1.services.DTO.ProjectDTO;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    private SkillRepository skillRepository;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;


    public ProjectService(ProjectRepository projectRepository, SkillRepository skillRepository) {
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    public List<ProjectDTO> getProjects(){
        return mapProjectsToDTOs(projectRepository.findAll());
    }

    public List<ProjectDTO> getProjectsForUser(String username){
        return mapProjectsToDTOs(projectRepository.findByCreator_Username(username));
    }

    public ProjectDTO getProject(Long id){
        return new ProjectDTO(projectRepository.getOne(id));
    }

    private List<ProjectDTO> mapProjectsToDTOs(List<Project> projects){
        return projects.stream().map( project -> new ProjectDTO(project)).collect(Collectors.toList());
    }

    public ProjectDTO addSkillToProject(Long id, String skillName){
        Project project = projectRepository.getOne(id);
        Skill skill;
        if(!skillRepository.findById(skillName).isPresent()){
            Skill s = new Skill();
            s.setName(skillName);
            skill = skillRepository.save(s);

            template.convertAndSend(fanout.getName(),"",skillName);

        }
        else {
            skill = skillRepository.getOne(skillName);
        }
        project.addSkills(skill);
        project = projectRepository.save(project);
        return new ProjectDTO(project);
    }
}
