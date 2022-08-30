package com.andreamaccan.backportfolio.controller;

import com.andreamaccan.backportfolio.model.Skill;
import com.andreamaccan.backportfolio.service.ISkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

    @Autowired
    private ISkill skillService;

    @GetMapping("/skill/get")
    @ResponseBody
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @GetMapping("/skill/get/{id}")
    @ResponseBody
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping("/skill/save")
    public void saveSkill(@RequestBody Skill skill) {
        skillService.saveSkill(skill);
    }
    
    @PutMapping("/skill/edit/{id}")
    public void editSkill(@PathVariable Long id, @RequestBody Skill skill) {
        skillService.editSkill(skill);
    }

    @DeleteMapping("/skill/delete/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}
