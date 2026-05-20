package com.project.lovable_clone.repositories;

import com.project.lovable_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
