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
public class Education implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Basic
    String thumb;
    String institution;
    String title;
    String details;
    String from_date;
    String to_date;
    int user_id;
    
    public Education() {

    }

    public Education(Long id, String thumb, String institution, String title, String details, String from_date, String to_date, int user_id) {
        this.id = id;
        this.thumb = thumb;
        this.institution = institution;
        this.title = title;
        this.details = details;
        this.from_date = from_date;
        this.to_date = to_date;
        this.user_id = user_id;
    }
}
