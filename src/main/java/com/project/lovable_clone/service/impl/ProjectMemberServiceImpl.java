package com.project.lovable_clone.service.impl;

import com.project.lovable_clone.dto.member.InviteMemberRequest;
import com.project.lovable_clone.dto.member.MemberResponse;
import com.project.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.project.lovable_clone.entity.Project;
import com.project.lovable_clone.entity.ProjectMember;
import com.project.lovable_clone.entity.ProjectMemeberId;
import com.project.lovable_clone.entity.User;
import com.project.lovable_clone.mappers.ProjectMemberResponseMapper;
import com.project.lovable_clone.repositories.ProjectMemberRepository;
import com.project.lovable_clone.repositories.ProjectRepository;
import com.project.lovable_clone.repositories.UserRepository;
import com.project.lovable_clone.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberResponseMapper projectMemberResponseMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        List<MemberResponse> memberResponsesList = new ArrayList<>();
        memberResponsesList.add(projectMemberResponseMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponsesList.addAll(projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberResponseMapper::toProjectMemberFromMember)
                .toList());
        return memberResponsesList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite urself");
        }

        ProjectMemeberId projectMemeberId = new ProjectMemeberId(projectId, invitee.getId());
        if (projectMemberRepository.existsById(projectMemeberId)) {
            throw new RuntimeException("ALreade there");
        }
        ProjectMember member = ProjectMember.builder().
                id(projectMemeberId).project(project).user(invitee).projectRole(request.role())
                .invitedAt(Instant.now()).
                build();

        projectMemberRepository.save(member);
        return projectMemberResponseMapper.toProjectMemberFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }

        //User invitee = userRepository.findByEmail(request.role()).orElseThrow();

        ProjectMemeberId projectMemeberId = new ProjectMemeberId(projectId, memberId);
        ProjectMember projectMember=projectMemberRepository.findById(projectMemeberId).orElseThrow();
        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberResponseMapper.toProjectMemberFromMember(projectMember);
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }
        ProjectMemeberId projectMemberId = new ProjectMemeberId(projectId, memberId);
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Not exists");
        }
        projectMemberRepository.deleteById(projectMemberId);



    }

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
