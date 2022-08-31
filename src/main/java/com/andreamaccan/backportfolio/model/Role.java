package com.andreamaccan.backportfolio.model;

import com.andreamaccan.backportfolio.enums.RoleEnums;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnums name;

    public Role() {
    }

    public Role(RoleEnums name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnums getName() {
        return name;
    }

    public void setName(RoleEnums name) {
        this.name = name;
    }

}
