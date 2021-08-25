package com.gunnarsson.smartlighter.exceptions;

public class PresetServiceException extends RuntimeException {
    private static final long serialVersionUID = 1626263922271876507L;

    public PresetServiceException(String message) {
        super(message);
    }
}
