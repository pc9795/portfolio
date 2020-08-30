package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.ProjectResponse;
import com.prashantchaubey.entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

  ProjectResponse to(Project project);
}
