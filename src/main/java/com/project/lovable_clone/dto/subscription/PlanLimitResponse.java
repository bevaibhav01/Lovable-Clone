package com.project.lovable_clone.dto.subscription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        boolean unlimited
) {

}
