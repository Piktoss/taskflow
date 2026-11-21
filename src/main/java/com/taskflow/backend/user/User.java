package com.taskflow.backend.user;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "email", nullable = false, length = 255,unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHashed;

    @Column(name = "profile_picture_path",length = 255)
    private String profilePicturePath;

    @Column(name = "created_at",nullable = false, insertable = false, updatable = false)
    private Instant createdAt;


    protected User() {
        // Required by JPA
    }

    public User(String username, String email, String passwordHashed, String profilePicturePath) {
        this.username = username;
        this.email = email;
        this.passwordHashed = passwordHashed;
        this.profilePicturePath = profilePicturePath;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return passwordHashed;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.passwordHashed = password;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
}
