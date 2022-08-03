package logic.portfolio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    int id;

    @Basic
    String skill;
    int percentage;

    public Skill() {

    }

    public Skill( int id, String skill, int percentage) {
      this.id = id;
      this.skill = skill;
      this.percentage = percentage;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getSkill() {
      return skill;
    }

    public void setSkill(String skill) {
      this.skill = skill;
    }

    public int getPercentage() {
      return percentage;
    }

    public void setPercentage(int percentage) {
      this.percentage = percentage;
    }

}

