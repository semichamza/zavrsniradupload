package ba.etf.zavrsni.mikroservis1.services.DTO;

import ba.etf.zavrsni.mikroservis1.domain.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String description;
    private String creator;
    private List<String> skills;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.description = project.getDescription();
        this.creator = project.getCreator().getUsername();
        this.skills = project.getSkills().stream().map( skill -> skill.getName()).collect(Collectors.toList());
    }
}
