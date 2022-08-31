package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
  
}
