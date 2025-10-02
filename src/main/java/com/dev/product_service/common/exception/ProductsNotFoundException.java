package com.dev.product_service.common.exception;

import org.springframework.http.HttpStatus;

public class ProductsNotFoundException extends RuntimeException {

    private static final String MESSAGE = "No products were found";
    public ProductsNotFoundException() {
        super(MESSAGE);
    }

    public HttpStatus getStatus(){
    return HttpStatus.NOT_FOUND;
  }
}
