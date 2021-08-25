package com.gunnarsson.smartlighter.exceptions;

public class UserServiceException extends RuntimeException{
    private static final long serialVersionUID = 1999722213111444607L;

    public UserServiceException(String message) {
        super(message);
    }
}
