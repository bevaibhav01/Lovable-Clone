package com.project.lovable_clone.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Plan {
    Long id;
    String name;
    String stripePriceId;
    Integer maxProjects;
    Integer  maxTokenPerDay; //max preview allowed
    Boolean unlimitedAI; //unlimited acces to LLM, ignore max token
    Boolean active;


}
