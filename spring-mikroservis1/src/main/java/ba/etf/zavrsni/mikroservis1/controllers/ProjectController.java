package ba.etf.zavrsni.mikroservis1.controllers;


import ba.etf.zavrsni.mikroservis1.services.DTO.ProjectDTO;
import ba.etf.zavrsni.mikroservis1.services.ProjectService;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {


    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping("/projects/user/{username}")
    public List<ProjectDTO> getProjectsOfUser(@PathVariable String username){
        return projectService.getProjectsForUser(username);
    }

    @GetMapping("/projects/{id}")
    public ProjectDTO getProject(@PathVariable Long id){
        return projectService.getProject(id);
    }

    @GetMapping("/projects/{id}/skills")
    public List<String> getProjectSkills(@PathVariable Long id){
        return projectService.getProject(id).getSkills();
    }

    @PostMapping("/projects/{id}/addSkill/{skill}")
    public ProjectDTO addSkillToProjec(@PathVariable Long id, @PathVariable String skill)
    {
        return projectService.addSkillToProject(id,skill);
    }
}
