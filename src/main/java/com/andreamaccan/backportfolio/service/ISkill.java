package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Skill;
import java.util.List;

public interface ISkill {
    public List<Skill> getSkills();
    public Skill getSkillById(Long id);
    public void saveSkill(Skill skill);
    public void editSkill(Skill skill);
    public void deleteSkill(Long id);
}
