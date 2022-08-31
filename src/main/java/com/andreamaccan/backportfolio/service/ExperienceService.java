package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Experience;
import com.andreamaccan.backportfolio.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperience {

    @Autowired
    public ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }
    
    @Override
    public void editExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}