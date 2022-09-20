package com.emin.placeslookup.exception;

public class LocationNotFoundException extends GenericException{

    public LocationNotFoundException() {
        super(ErrorCode.NotFound.getCode());
    }

    public LocationNotFoundException(String message) {
        super(ErrorCode.NotFound.getCode(), message);
    }

    public LocationNotFoundException(String message, Throwable cause) {
        super(ErrorCode.NotFound.getCode(), message, cause);
    }
}
