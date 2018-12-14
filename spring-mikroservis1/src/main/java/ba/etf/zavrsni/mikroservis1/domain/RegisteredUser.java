package ba.etf.zavrsni.mikroservis1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Proc;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegisteredUser {
    @Id
    @Column(unique = true)
    private String username;

    private String email;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Collection<Project> projects = new HashSet<Project>();

}
