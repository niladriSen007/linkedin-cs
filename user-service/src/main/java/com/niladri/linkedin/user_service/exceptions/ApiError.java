package com.niladri.linkedin.user_service.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
  private LocalDateTime timestamp;
  private String message;
  private HttpStatus statusCode;

  public ApiError() {
    this.timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus statusCode, String message) {
    this();
    this.statusCode = statusCode;
    this.message = message;
  }
}
