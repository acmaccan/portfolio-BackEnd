package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Project;
import com.andreamaccan.backportfolio.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProject {

    @Autowired
    public ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }
    
    @Override
    public void editProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
