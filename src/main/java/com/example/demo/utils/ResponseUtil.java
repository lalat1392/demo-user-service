package com.example.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseUtil {

    /**
     * @param statusCode
     * @param message
     * @param result
     * @return
     */
    public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message,
                                                          final Object result) {
        return ResponseEntity.ok().body(new ApiResponse(statusCode.value(), message, result));
    }

    public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message) {
        return getResponse(statusCode, message, null);
    }

}