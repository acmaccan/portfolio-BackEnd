package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.Education;
import java.util.List;

public interface IEducation {
    public List<Education> getEducations();
    public Education getEducationById(Long id);
    public void saveEducation(Education education);
    public void editEducation(Education education);
    public void deleteEducation(Long id);
}
