package com.dev.product_service.common.dto;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public record ErrorListDTO(
        String timestamp,
        int status,
        String error,
        String message,
        List<FieldErrorDTO> errors,
        String path) {
    public static ErrorListDTO of(HttpStatus status, String message, List<FieldErrorDTO> errors, String path){
        return new ErrorListDTO(
                Instant.now().truncatedTo(ChronoUnit.MILLIS).toString(),
                status.value(),
                status.getReasonPhrase(),
                message,
                errors,
                path
        );
    }
}
