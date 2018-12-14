package ba.etf.zavrsni.mikroservis1.repositories;

import ba.etf.zavrsni.mikroservis1.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    public List<Project> findByCreator_Username(String username);
}
