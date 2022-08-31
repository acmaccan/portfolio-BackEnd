package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
  
}
