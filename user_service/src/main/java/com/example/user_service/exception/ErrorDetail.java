package com.example.user_service.exception;

import com.example.user_service.enums.ResponseENUM;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private boolean success;
    private ResponseENUM errorCode;
    private String message;
    private String path;
    private LocalDateTime timestamp;

}
