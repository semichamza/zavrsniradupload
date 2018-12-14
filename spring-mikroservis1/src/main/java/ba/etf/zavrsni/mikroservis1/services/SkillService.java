package ba.etf.zavrsni.mikroservis1.services;

import ba.etf.zavrsni.mikroservis1.domain.Skill;
import ba.etf.zavrsni.mikroservis1.repositories.SkillRepository;
import ba.etf.zavrsni.mikroservis1.services.DTO.SkillDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillDTO> getSkills(){
        return mapSkillsToDTOs(skillRepository.findAll());
    }

    public SkillDTO getSkill(String name){
        return new SkillDTO(skillRepository.getOne(name));
    }


    private List<SkillDTO> mapSkillsToDTOs(List<Skill> skills){
        return skills.stream().map( skill -> new SkillDTO(skill)).collect(Collectors.toList());
    }
}
