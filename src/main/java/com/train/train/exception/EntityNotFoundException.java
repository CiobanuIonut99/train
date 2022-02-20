package com.train.train.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
