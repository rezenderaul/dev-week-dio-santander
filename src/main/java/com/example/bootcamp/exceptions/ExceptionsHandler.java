package com.example.bootcamp.exceptions;

import com.example.bootcamp.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionsHandler {
    

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFound exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(this.standard(
                status, exception.getMessage(), request, MessageUtils.ENTITY_NOT_FOUND));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandardError> handlerSecurity(ResourceNotFound exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(status).body(this.standard(
                status, exception.getMessage(), request, MessageUtils.STOCK_ALREADY_EXISTS));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handlerSecurity(Exception exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(this.standard(
                status, exception.getMessage(), request, MessageUtils.SERVER_ERROR));
    }

    private StandardError standard(HttpStatus status, String error, HttpServletRequest request, String message) {
        return StandardError.builder()
            .timeStamp(Instant.now())
            .status(status.value())
            .error(error)
            .message(message)
            .path(request.getRequestURI())
            .build();
    }

}