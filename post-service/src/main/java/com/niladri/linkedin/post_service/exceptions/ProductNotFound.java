package com.niladri.linkedin.post_service.exceptions;

public class ProductNotFound extends RuntimeException  {
  public ProductNotFound(String message) {
    super(message);
  }
  
  public ProductNotFound(String message, Throwable cause) {
    super(message, cause);
  }
}
