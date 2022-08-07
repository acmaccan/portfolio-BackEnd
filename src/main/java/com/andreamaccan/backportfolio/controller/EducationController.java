package com.andreamaccan.backportfolio.controller;

import com.andreamaccan.backportfolio.model.Education;
import com.andreamaccan.backportfolio.service.IEducation;
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
public class EducationController {

    @Autowired
    private IEducation educationService;

    @GetMapping("/education/get")
    @ResponseBody
    public List<Education> getEducations() {
        return educationService.getEducations();
    }

    @GetMapping("/education/get/{id}")
    @ResponseBody
    public Education getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping("/education/save")
    public void saveEducation(@RequestBody Education education) {
        educationService.saveEducation(education);
    }
    
    @PutMapping("/education/edit")
    public void editEducation(@RequestBody Education education) {
        educationService.editEducation(education);
    }

    @DeleteMapping("/education/delete/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
