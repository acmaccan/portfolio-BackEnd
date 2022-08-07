package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Experience;
import java.util.List;

public interface IExperience {
    public List<Experience> getExperiences();
    public Experience getExperienceById(Long id);
    public void saveExperience(Experience experience);
    public void editExperience(Experience experience);
    public void deleteExperience(Long id);
}
