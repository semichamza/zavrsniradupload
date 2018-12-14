package ba.etf.zavrsni.mikroservis1.services;

import ba.etf.zavrsni.mikroservis1.domain.Project;
import ba.etf.zavrsni.mikroservis1.repositories.ProjectRepository;
import ba.etf.zavrsni.mikroservis1.services.DTO.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
}
