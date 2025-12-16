package com.project.lovable_clone.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
public class Project {

    Long id;
    String name;
    User owner;
    Boolean isPublic=false;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;


}
