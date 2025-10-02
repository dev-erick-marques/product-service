package com.dev.product_service.common.exception;

import org.springframework.http.HttpStatus;

public class CategoriesNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No categories were found";
    public CategoriesNotFoundException() {
        super(MESSAGE);
    }
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }
}
