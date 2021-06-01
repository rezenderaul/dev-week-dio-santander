package com.example.bootcamp.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    
}