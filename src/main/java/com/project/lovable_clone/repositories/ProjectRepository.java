package com.project.lovable_clone.repositories;

import com.project.lovable_clone.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {


    @Query(
                    """
                    SELECT p FROM Project p
                    WHERE p.deletedAt IS NULL
                    AND p.owner.id=:userId
                    """
    )
    List<Project> findAllProjectAccesibleByUser(@Param("userId") Long userId);
}
