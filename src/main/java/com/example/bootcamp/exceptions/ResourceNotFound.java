package com.example.bootcamp.exceptions;

import com.example.bootcamp.util.MessageUtils;

public class ResourceNotFound extends RuntimeException {
 
    public ResourceNotFound() {
        super(MessageUtils.ENTITY_NOT_FOUND);
    }

}