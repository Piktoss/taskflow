package com.taskflow.backend.dto;

import java.time.Instant;

public record UserResponse(Long id, String username, Instant createdAt) {
}
