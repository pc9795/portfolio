package com.prashantchaubey.caches;

import com.prashantchaubey.entities.Project;
import com.prashantchaubey.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProjectCache {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectCache(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Page<Project> findByOrderByCreatedAtDesc(Pageable pageable) {
        return projectRepository.findByOrderByCreatedAtDesc(pageable);
    }
}
