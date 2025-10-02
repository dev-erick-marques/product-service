package com.dev.product_service.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public static final String MESSAGE = "Category not found";
    public CategoryNotFoundException() {
        super(MESSAGE);
    }

    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }

}

