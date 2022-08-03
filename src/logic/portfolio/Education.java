package logic.portfolio;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Basic
    String thumb;
    String institution;
    String title;
    String details;
    String from_date;
    String to_date;

    public Education() {
        
    }

    public Education(int id, String thumb, String institution, String title, String details, String from_date, String to_date) {
        this.id = id;
        this.thumb = thumb;
        this.institution = institution;
        this.title = title;
        this.details = details;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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

    public String getFromDate() {
        return from_date;
    }

    public void setFromDate(String from_date) {
        this.from_date = from_date;
    }

    public String getToDate() {
        return to_date;
    }

    public void setToDate(String to_date) {
        this.to_date = to_date;
    }


}