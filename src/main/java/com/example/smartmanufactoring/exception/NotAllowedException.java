package com.example.smartmanufactoring.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String errorMessage) {
        super(errorMessage);
    }
}
