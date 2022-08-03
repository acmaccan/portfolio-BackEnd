package logic.portfolio;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Basic
    String image;
    String title;
    String details;
    String link;
    String project_year;

    public Project() {
        
    }

    public Project(int id, String image, String title, String details, String link, String project_year) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.details = details;
        this.link = link;
        this.project_year = project_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProjectYear() {
        return project_year;
    }

    public void setProjectYear(String project_year) {
        this.project_year = project_year;
    }
}