package com.project.lovable_clone.mappers;

import com.project.lovable_clone.dto.member.MemberResponse;
import com.project.lovable_clone.entity.ProjectMember;
import com.project.lovable_clone.entity.User;
import com.project.lovable_clone.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberResponseMapper {

    @Mapping(target = "userId",source="id")
    @Mapping(target = "projectRole",constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "email",source = "user.email")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberFromMember(ProjectMember member);
}
