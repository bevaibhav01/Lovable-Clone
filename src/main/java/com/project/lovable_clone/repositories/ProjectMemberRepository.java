package com.project.lovable_clone.repositories;

import com.project.lovable_clone.entity.ProjectMember;
import com.project.lovable_clone.entity.ProjectMemeberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemeberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);


}
