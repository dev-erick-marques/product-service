package com.dev.product_service.common.handler;

import com.dev.product_service.common.dto.ErrorListDTO;
import com.dev.product_service.common.dto.ErrorResponseDTO;
import com.dev.product_service.common.dto.FieldErrorDTO;
import com.dev.product_service.common.exception.CategoriesNotFoundException;
import com.dev.product_service.common.exception.CategoryNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private <T> ResponseEntity<T> buildResponse(HttpStatus status, T body){
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> incorrectJsonHandler(HttpMessageNotReadableException ex, HttpServletRequest request){
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorListDTO> fieldValidationHandlers(MethodArgumentNotValidException ex, HttpServletRequest request){
        var errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(field -> new FieldErrorDTO(field.getField(), field.getDefaultMessage()))
                .toList();
        String message = "Validation error: some fields are missing or incorrect.";
        return  errorListResponse(message,(HttpStatus) ex.getStatusCode(),errors,request.getRequestURI());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> categoryNotFoundHandler(CategoryNotFoundException ex, HttpServletRequest request){
        return buildResponse(ex.getStatus(), ex.getMessage(), request);
    }
    @ExceptionHandler(CategoriesNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> categoriesNotFoundHandler(CategoriesNotFoundException ex, HttpServletRequest request){
        return buildResponse(ex.getStatus(), ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> genericHandler(Exception ex, HttpServletRequest request){
        String message = "Unexpected error";
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, message, request);
    }


    public ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus status,String message,HttpServletRequest request){
        ErrorResponseDTO response = ErrorResponseDTO.of(status,message,request.getRequestURI());
        return buildResponse(status,response);

    }
    public ResponseEntity<ErrorListDTO> errorListResponse(String message, HttpStatus status, List<FieldErrorDTO> errors, String path){
        ErrorListDTO response = ErrorListDTO.of(status,message, errors, path);
        return buildResponse(status,response);
    }

}