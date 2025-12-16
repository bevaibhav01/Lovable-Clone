package com.project.lovable_clone.entity;

import com.project.lovable_clone.enums.ProjectRole;

import java.time.Instant;

public class ProjectMember {
    ProjectMemeberId id;
    Project project;
    User user;
    ProjectRole role;
    Instant invitedAt;
    Instant acceptedAt;

}
