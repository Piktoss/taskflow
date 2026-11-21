package com.taskflow.backend.dto.user;

import java.time.Instant;

public record UserResponse(Long id,
                           String username,
                           String profilePicture ,
                           Instant createdAt) {
}
