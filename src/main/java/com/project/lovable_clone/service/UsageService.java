package com.project.lovable_clone.service;

import com.project.lovable_clone.dto.subscription.PlanLimitResponse;
import com.project.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionOfUser(Long userId);
}
