package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.ProjectCache;
import com.prashantchaubey.dto.mappers.ProjectMapper;
import com.prashantchaubey.dto.responses.ProjectResponse;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(Constants.Resource.PROJECTS_V1)
public class ProjectResource {

    private ProjectCache projectCache;
    private ProjectMapper projectMapper;

    @Autowired
    public ProjectResource(ProjectCache projectCache, ProjectMapper projectMapper) {
        this.projectCache = projectCache;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public Page<ProjectResponse> getAll(Pageable pageable) {
        return projectCache.findByOrderByCreatedAtDesc(pageable).map(projectMapper::to);
    }
}
