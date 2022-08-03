package logic.portfolio;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Basic
    String thumb;
    String company;
    String title;
    String details;
    String from_date;
    String to_date;

    public Experience() {
        
    }

    public Experience(int id, String thumb, String company, String title, String details, String from_date, String to_date) {
        this.id = id;
        this.thumb = thumb;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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