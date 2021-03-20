package com.springboot.sbdemo.dto;

public class DefaultResponse {

    private String status;

    private String message;

    public DefaultResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
