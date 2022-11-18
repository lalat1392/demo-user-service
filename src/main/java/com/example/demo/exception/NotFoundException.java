package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="User Not Found")
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
