package com.project.lovable_clone.mappers;


import com.project.lovable_clone.dto.project.ProjectResponse;
import com.project.lovable_clone.dto.project.ProjectSummaryResponse;
import com.project.lovable_clone.entity.Project;
import com.project.lovable_clone.repositories.ProjectRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectReponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);
}
