package com.andreamaccan.backportfolio.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
// The model name will give the database column name 
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Basic
    String image;
    String title;
    String details;
    String link;
    String project_year;
    int user_id;

    public Project() {

    }

    public Project(Long id, String image, String title, String details, String link, String project_year, int user_id) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.project_year = project_year;
        this.details = details;
        this.link = link;
        this.user_id = user_id;
    }
}
