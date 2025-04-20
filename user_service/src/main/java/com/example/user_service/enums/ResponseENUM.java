package com.example.user_service.enums;

import org.springframework.http.HttpStatus;

public enum ResponseENUM {



    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus status;

    ResponseENUM(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
