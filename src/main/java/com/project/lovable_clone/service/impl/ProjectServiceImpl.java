package com.project.lovable_clone.service.impl;

import com.project.lovable_clone.dto.project.ProjectRequest;
import com.project.lovable_clone.dto.project.ProjectResponse;
import com.project.lovable_clone.dto.project.ProjectSummaryResponse;
import com.project.lovable_clone.entity.Project;
import com.project.lovable_clone.entity.User;
import com.project.lovable_clone.mappers.ProjectMapper;
import com.project.lovable_clone.repositories.ProjectRepository;
import com.project.lovable_clone.repositories.UserRepository;
import com.project.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    @Override
    public List<ProjectSummaryResponse> getUserProject(Long userId) {
        //get project
        return projectRepository.findAllProjectAccesibleByUser(userId)
                .stream()
                .map(projectMapper::toProjectSummaryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {

        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project
                .builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        Project savedProject=projectRepository.save(project);

        return projectMapper.toProjectReponse(savedProject);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
