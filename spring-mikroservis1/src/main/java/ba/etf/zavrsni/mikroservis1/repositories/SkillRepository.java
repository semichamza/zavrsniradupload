package ba.etf.zavrsni.mikroservis1.repositories;

import ba.etf.zavrsni.mikroservis1.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository<Skill,String> {
}
