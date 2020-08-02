package com.prashantchaubey.api.v1;

import com.prashantchaubey.caches.ProjectCache;
import com.prashantchaubey.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Resource.PROJECTS_V1)
public class ProjectResource {

    private ProjectCache projectCache;

    @Autowired
    public ProjectResource(ProjectCache projectCache) {
        this.projectCache = projectCache;
    }
}
