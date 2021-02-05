package com.marshall.customersubscriptionservice.exception;

public class UserNotExistsException extends Exception {
    public UserNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}