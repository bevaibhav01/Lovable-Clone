package com.project.lovable_clone.dto.subscription;

public record PlanResponse (
        Long id,
        String name,
        String stripePriceId,
        Integer maxProjects,
        Integer  maxTokenPerDay, //max preview allowed
        Boolean unlimitedAI
){
}
