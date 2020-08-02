package com.prashantchaubey.dto.mappers;

import com.prashantchaubey.dto.responses.GetProjectResponse;
import com.prashantchaubey.entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    GetProjectResponse to(Project project);
}
