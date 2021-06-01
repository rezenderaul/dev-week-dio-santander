package com.example.bootcamp.exceptions;

import com.example.bootcamp.util.MessageUtils;

public class BusinessException extends RuntimeException {
 
    public BusinessException() {
        super(MessageUtils.ENTITY_NOT_FOUND);
    }

}