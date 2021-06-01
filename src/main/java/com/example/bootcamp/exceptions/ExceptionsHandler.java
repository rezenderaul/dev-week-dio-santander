package com.example.bootcamp.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.example.bootcamp.util.MessageUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> entityNotFound(BusinessException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(standard(status, MessageUtils.ENTITY_NOT_FOUND, request));
    }

    private StandardError standard(HttpStatus status, String error, HttpServletRequest request) {
        return StandardError.builder()
            .timeStamp(Instant.now())
            .status(status.value())
            .error(error)
            .message("exception")
            .path(request.getRequestURI())
            .build();
            
    }

}