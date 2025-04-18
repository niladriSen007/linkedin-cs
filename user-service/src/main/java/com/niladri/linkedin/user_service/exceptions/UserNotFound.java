package com.niladri.linkedin.user_service.exceptions;

public class UserNotFound extends RuntimeException  {
  public UserNotFound(String message) {
    super(message);
  }
  
  public UserNotFound(String message, Throwable cause) {
    super(message, cause);
  }
}
