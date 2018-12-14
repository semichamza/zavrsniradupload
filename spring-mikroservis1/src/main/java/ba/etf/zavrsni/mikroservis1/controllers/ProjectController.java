package ba.etf.zavrsni.mikroservis1.controllers;


import ba.etf.zavrsni.mikroservis1.services.DTO.ProjectDTO;
import ba.etf.zavrsni.mikroservis1.services.ProjectService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    @GetMapping("/projects/{id}/getappropriateusers")
    public String getUsersForProject(@PathVariable Long id) {
        ProjectDTO projectDTO = projectService.getProject(id);
        Body body = new Body();
        body.setSkills(projectDTO.getSkills());
        var response = (new RestTemplate()).postForEntity("http://localhost:3000/api/user/find_users_by_skills",body, String.class);

        return response.getBody().toString();
    }

    @NoArgsConstructor
    @Getter
    @Setter
    private class Body{
        private List<String> skills;
    }

}
