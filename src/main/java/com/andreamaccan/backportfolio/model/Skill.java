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
public class Skill implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Basic
    String skill;
    int percentage;
    int user_id;

    public Skill() {

    }

    public Skill(Long id, String skill, int percentage, int user_id) {
      this.id = id;
      this.skill = skill;
      this.percentage = percentage;
      this.user_id = user_id;
    }
}
