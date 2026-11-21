package com.taskflow.backend.exception;

public class UsernameNotAvailable extends RuntimeException {
    public UsernameNotAvailable(String message) {
        super(message);
    }
}
