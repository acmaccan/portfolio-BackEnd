package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Education;
import com.andreamaccan.backportfolio.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducation {

    @Autowired
    public EducationRepository educationRepository;

    @Override
    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Education getEducationById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }
    
    @Override
    public void editEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}