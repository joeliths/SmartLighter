package com.gunnarsson.smartlighter.exceptions;

public class LightServiceException extends RuntimeException{
    private static final long serialVersionUID = 1111721913171435607L;

    public LightServiceException(String message) {
        super(message);
    }

}
