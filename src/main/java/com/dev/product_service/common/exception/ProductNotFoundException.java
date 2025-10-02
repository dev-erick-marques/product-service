package com.dev.product_service.common.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException {
  private static final String MESSAGE = "Product not found";
  public ProductNotFoundException() {
    super(MESSAGE);
  }
  public HttpStatus getStatus(){
    return HttpStatus.NOT_FOUND;
  }
}
