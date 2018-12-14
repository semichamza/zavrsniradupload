package ba.etf.zavrsni.mikroservis1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonIgnore
    @ManyToOne
    private RegisteredUser creator;

    @ManyToMany
    private Collection<Skill> skills = new HashSet<Skill>();

    public void addSkills(Skill... skills){
        this.skills.addAll(Arrays.asList(skills));
    }
}
