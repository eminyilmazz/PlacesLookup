package com.emin.placeslookup.exception;

public enum ErrorCode {
    NotFound(1);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
