package com.marshall.customersubscriptionservice.web.exception.handling;

import com.marshall.customersubscriptionservice.exception.UserNotExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = UserNotExistsException.class)
    protected ResponseEntity<Object> handleException(UserNotExistsException e, WebRequest request) {
        String responseBody = e.getMessage();
        return handleExceptionInternal(e, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<Object> handleException(IllegalArgumentException e, WebRequest request) {
        String responseBody = e.getMessage();
        return handleExceptionInternal(e, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}