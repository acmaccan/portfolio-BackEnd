package logic.portfolio;

import java.util.List;
import persistence.portfolio.PersistenceController;

public class LogicController {
    PersistenceController persistenceController = new PersistenceController();

    /* Education */
    public void createEducation(Education education) {
        persistenceController.createEducation(education);
    }
    
    public void removeEducation(int id) {
        persistenceController.removeEducation(id);
    }
    
    public List<Education> getEducation() {
        return persistenceController.getEducation();
    }
    
    /* Experience */
    public void createExperience(Experience experience) {
        persistenceController.createExperience(experience);
    }
    
    public void removeExperience(int id) {
        persistenceController.removeExperience(id);
    }
    
    public List<Experience> getExperience() {
        return persistenceController.getExperience();
    }

    /* Project */
    public void createProject(Project project) {
        persistenceController.createProject(project);
    }
    
    public void removeProject(int id) {
        persistenceController.removeProject(id);
    }
    
    public List<Project> getProject() {
        return persistenceController.getProject();
    }
    
    /* Skill */
    public void createSkill(Skill skill) {
        persistenceController.createSkill(skill);
    }
    
    public void removeSkill(int id) {
        persistenceController.removeSkill(id);
    }
    
    public List<Skill> getSkill() {
        return persistenceController.getSkill();
    }
  
    /* User */
    public void createUser(User user) {
        persistenceController.createUser(user);
    }
    
    public void removeUser(int id) {
        persistenceController.removeUser(id);
    }
    
    public List<User> getUser() {
        return persistenceController.getUser();
    }
    
}
