package com.niladri.linkedin.post_service.exceptions;

public class UnableToUnlike extends RuntimeException {
    public UnableToUnlike(String message) {
        super(message);
    }

    public UnableToUnlike(String message, Throwable cause) {
        super(message, cause);
    }
  
}
