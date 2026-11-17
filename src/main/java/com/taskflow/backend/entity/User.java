package com.taskflow.backend.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "email", nullable = false, length = 255,unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_picture_path",length = 255)
    private String profilePicturePath;

    @Column(name = "created_at")
    private Instant createdAt;

}
