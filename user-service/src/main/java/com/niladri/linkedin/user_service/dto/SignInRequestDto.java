package com.niladri.linkedin.user_service.dto;

import lombok.Data;

@Data
public class SignInRequestDto {
  private String email;
  private String password;
}
