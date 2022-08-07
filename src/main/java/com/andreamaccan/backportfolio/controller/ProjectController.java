package com.andreamaccan.backportfolio.controller;

import com.andreamaccan.backportfolio.model.Project;
import com.andreamaccan.backportfolio.service.IProject;
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
public class ProjectController {

    @Autowired
    private IProject projectService;

    @GetMapping("/project/get")
    @ResponseBody
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/project/get/{id}")
    @ResponseBody
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/project/save")
    public void saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
    }
    
    @PutMapping("/project/edit")
    public void editProject(@RequestBody Project project) {
        projectService.editProject(project);
    }

    @DeleteMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
