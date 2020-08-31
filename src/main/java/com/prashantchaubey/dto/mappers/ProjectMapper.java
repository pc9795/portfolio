package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.ProjectResponse;
import com.prashantchaubey.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

  ProjectResponse to(Project project);
}
