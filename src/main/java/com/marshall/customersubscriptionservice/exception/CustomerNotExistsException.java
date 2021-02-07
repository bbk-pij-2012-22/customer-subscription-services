package com.marshall.customersubscriptionservice.exception;

public class CustomerNotExistsException extends Exception {
    public CustomerNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}