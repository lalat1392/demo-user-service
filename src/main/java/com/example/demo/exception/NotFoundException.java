package com.example.demo.exception;

public class NotFoundException extends RuntimeException {
    private Integer errorCode;

    public NotFoundException(String errorMessage, ErrorCode errorCode) {
        super(errorMessage);
        this.errorCode = errorCode.getCode();
    }
    public Integer getErrorCode() {
        return errorCode;
    }

}
