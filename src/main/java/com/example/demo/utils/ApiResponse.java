package com.example.demo.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApiResponse implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The status.
     */
    private int status;

    /**
     * The message.
     */
    private String message;

    /**
     * The data.
     */
    private transient Object result;

    /**
     * @param status
     * @param message
     * @param result
     */
    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
