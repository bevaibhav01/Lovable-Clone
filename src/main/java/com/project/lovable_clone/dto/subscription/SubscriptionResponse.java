package com.project.lovable_clone.dto.subscription;

import com.project.lovable_clone.entity.Plan;

import java.time.Instant;

public record SubscriptionResponse(
        Plan plan,
        String status,
        Instant periodEnd,
        Long tokenUsedInThisCycle
) {
}
