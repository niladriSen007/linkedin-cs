package com.niladri.linkedin.user_service.service;

import com.niladri.linkedin.user_service.dto.SignInRequestDto;
import com.niladri.linkedin.user_service.dto.SignupRequestDto;
import com.niladri.linkedin.user_service.dto.UserResponseDto;

public interface IUserService {
  UserResponseDto signUp(SignupRequestDto signupRequestDto);
  String signIn(SignInRequestDto signinRequestDto);
}
