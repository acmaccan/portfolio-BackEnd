package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
  
}
