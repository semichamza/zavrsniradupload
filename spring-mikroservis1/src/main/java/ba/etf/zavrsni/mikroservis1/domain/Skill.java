package ba.etf.zavrsni.mikroservis1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "skills")
    private Collection<Project> projects = new HashSet<Project>();
}
