package com.example.bootcamp.exceptions;

import lombok.*;

import java.time.Instant;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}