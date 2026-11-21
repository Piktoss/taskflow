package com.taskflow.backend.user.dto;

import java.time.Instant;

public record UserResponse(Long id,
                           String username,
                           String profilePicture ,
                           Instant createdAt) {
}
