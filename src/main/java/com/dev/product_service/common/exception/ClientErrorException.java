package com.dev.product_service.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientErrorException extends RuntimeException {
  private final HttpStatus status;

  public ClientErrorException(String message, HttpStatus status) {
    super(message);
    if (!status.is4xxClientError()){
      throw new IllegalArgumentException("ClientErrorException only accept 4xx errors");
    }
    this.status = status;
  }

}
