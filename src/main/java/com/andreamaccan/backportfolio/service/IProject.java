package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Project;
import java.util.List;

public interface IProject {
    public List<Project> getProjects();
    public Project getProjectById(Long id);
    public void saveProject(Project project);
    public void editProject(Project project);
    public void deleteProject(Long id);
}
