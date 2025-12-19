package com.project.lovable_clone.service;

import com.project.lovable_clone.dto.subscription.CheckoutRequest;
import com.project.lovable_clone.dto.subscription.CheckoutResponse;
import com.project.lovable_clone.dto.subscription.PortalResponse;
import com.project.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
