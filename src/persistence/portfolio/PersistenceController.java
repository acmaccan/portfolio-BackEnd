package persistence.portfolio;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.portfolio.Education;
import logic.portfolio.Experience;
import logic.portfolio.User;
import logic.portfolio.Project;
import logic.portfolio.Skill;
import persistence.portfolio.exceptions.NonexistentEntityException;

public class PersistenceController {

    /* Education */
    EducationJpaController educationJPA = new EducationJpaController();
    
    public void createEducation(Education education) {
        educationJPA.create(education);
    }
    
    public void removeEducation(int id) {
        try {
            educationJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Education> getEducation() {
        return educationJPA.findEducationEntities();
    }
    
    /* Experience */
    ExperienceJpaController experienceJPA = new ExperienceJpaController();
    
    public void createExperience(Experience experience) {
        experienceJPA.create(experience);
    }
    
    public void removeExperience(int id) {
        try {
            experienceJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Experience> getExperience() {
        return experienceJPA.findExperienceEntities();
    }
    
    
    /* Project */
    ProjectJpaController projectJPA = new ProjectJpaController();
    
    public void createProject(Project project) {
        projectJPA.create(project);
    }
    
    public void removeProject(int id) {
        try {
            projectJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Project> getProject() {
        return projectJPA.findProjectEntities();
    }
    
    /* Skill */
    SkillJpaController skillJPA = new SkillJpaController();
    
    public void createSkill(Skill skill) {
        skillJPA.create(skill);
    }
    
    public void removeSkill(int id) {
        try {
            skillJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Skill> getSkill() {
        return skillJPA.findSkillEntities();
    }
    
    /* User */
    UserJpaController userJPA = new UserJpaController();
    
    public void createUser(User user) {
        userJPA.create(user);
    }
    
    public void removeUser(int id) {
        try {
            userJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<User> getUser() {
        return userJPA.findUserEntities();
    }
}
