package ba.etf.zavrsni.mikroservis1.services.DTO;

import ba.etf.zavrsni.mikroservis1.domain.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkillDTO {
    private String name;

    public SkillDTO(Skill skill){
        this.name = skill.getName();
    }
}
