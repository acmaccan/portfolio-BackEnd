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
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Basic
    String firstname;
    String lastname;
    String birthday;
    String nationality;
    String email;
    String password;
    String about;
    String title;
    String avatar;
    String banner;
    String location;

    public User() {

    }

    public User(Long id, String firstname, String lastname, String birthday, String nationality, String email, String password, String about, String title, String avatar, String banner, String location) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.nationality = nationality;
        this.email = email;
        this.password = password;
        this.about = about;
        this.title = title;
        this.avatar = avatar;
        this.banner = banner;
        this.location = location;
    }
}
