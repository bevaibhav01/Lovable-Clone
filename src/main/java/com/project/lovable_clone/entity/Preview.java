package com.project.lovable_clone.entity;

import com.project.lovable_clone.enums.PreviewStatus;

import java.time.Instant;

public class Preview {
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;

}
