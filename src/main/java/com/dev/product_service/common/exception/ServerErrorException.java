package com.dev.product_service.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerErrorException extends RuntimeException {
  private final HttpStatus status;

  public ServerErrorException(String message, HttpStatus status) {
    super(message);
    if(!status.is5xxServerError()){
      throw new IllegalArgumentException("ServerErrorException only accept 5xx errors");
    }
    this.status = status;
  }
}
