package com.project.lovable_clone.dto.project;

import java.time.Instant;
import java.util.List;

public record FileTreeResponse(
      List<FileNode> files
) {
}
