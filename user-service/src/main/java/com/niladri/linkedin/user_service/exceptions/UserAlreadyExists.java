package com.niladri.linkedin.user_service.exceptions;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super(message);
    }
    public UserAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }
  
}
