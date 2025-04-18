package com.niladri.linkedin.user_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UserNotFound.class)
  public ResponseEntity<ApiError> handleUserNotFound(UserNotFound ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<ApiError> handleBadRequest(BadRequest ex) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserAlreadyExists.class)
  public ResponseEntity<ApiError> handleUserAlreadyExists(UserAlreadyExists ex) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleGenericException(Exception ex) {
    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + ex.getLocalizedMessage());
    return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
