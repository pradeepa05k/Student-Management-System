package com.infinira.sms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

import org.json.JSONObject;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {  
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Object> handleThrowable(Exception ex, WebRequest request) {
        JSONObject json = new JSONObject();
        json.put("success", "false");
        json.put("errorMessage", ex.getMessage());
        return handleExceptionInternal(ex, json.toString(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }    
}