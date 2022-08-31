package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Skill;
import com.andreamaccan.backportfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkill {

    @Autowired
    public SkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }
    
    @Override
    public void editSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

}
