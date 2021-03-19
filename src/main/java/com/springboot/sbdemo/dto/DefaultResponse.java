package com.springboot.sbdemo.dto;

public class DefaultResponse {

    private boolean success;

    private String message;

    public DefaultResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
