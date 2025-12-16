package com.project.lovable_clone.entity;

import lombok.*;


import java.time.Instant;

//@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

    private Long id;
    private String email;
    private String passwordHash;
    private String avatarUrl;
    //Learn about Instant
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

}
