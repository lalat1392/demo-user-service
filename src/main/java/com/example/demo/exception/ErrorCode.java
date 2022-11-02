package com.example.demo.exception;

public enum ErrorCode {

    NOT_FOUND(404);
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
