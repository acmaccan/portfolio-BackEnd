package com.andreamaccan.backportfolio.controller;

import com.andreamaccan.backportfolio.model.Experience;
import com.andreamaccan.backportfolio.service.IExperience;
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
public class ExperienceController {

    @Autowired
    private IExperience experienceService;

    @GetMapping("/experience/get")
    @ResponseBody
    public List<Experience> getExperiences() {
        return experienceService.getExperiences();
    }

    @GetMapping("/experience/get/{id}")
    @ResponseBody
    public Experience getExperienceById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @PostMapping("/experience/save")
    public void saveExperience(@RequestBody Experience experience) {
        experienceService.saveExperience(experience);
    }
    
    @PutMapping("/experience/edit/{id}")
    public void editExperience(@PathVariable Long id, @RequestBody Experience experience) {
        experienceService.editExperience(experience);
    }

    @DeleteMapping("/experience/delete/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}
