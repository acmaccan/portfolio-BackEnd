package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
  
}
