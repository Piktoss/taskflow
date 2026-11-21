package com.taskflow.backend.exception;

public class EmailNotAvailable extends RuntimeException {
    public EmailNotAvailable(String message) {
        super(message);
    }
}
