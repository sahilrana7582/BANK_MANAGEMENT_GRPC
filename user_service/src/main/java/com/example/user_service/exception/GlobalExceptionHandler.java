package com.example.user_service.exception;


import com.example.user_service.enums.ResponseENUM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetail errorDetail = ErrorDetail.builder()
                .success(false)
                .message(ex.getMessage())
                .path("")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getStatus()).body(errorDetail);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleException(Exception ex) {
        ErrorDetail errorDetail = ErrorDetail.builder()
                .success(false)
                .errorCode(ResponseENUM.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .path("")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ResponseENUM.INTERNAL_SERVER_ERROR.getStatus()).body(errorDetail);
    }
}
