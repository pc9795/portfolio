package com.prashantchaubey.repositories;

import com.prashantchaubey.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

  Page<Project> findByOrderByCreatedAtDesc(Pageable pageable);
}
