package com.emin.placeslookup.exception;

public class GenericException extends Exception{

    private int code;

    private String message;

    public GenericException(int code, String message) {
        super(message);
        this.setCode(code);
        this.setMessage(message);
    }

    public GenericException(int code) {
        super();
        this.setCode(code);
    }

    public GenericException(int code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
        this.setMessage(message);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }
}
