package com.niladri.linkedin.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.linkedin.user_service.dto.SignInRequestDto;
import com.niladri.linkedin.user_service.dto.SignupRequestDto;
import com.niladri.linkedin.user_service.dto.UserResponseDto;
import com.niladri.linkedin.user_service.service.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
// @CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AuthController {

  private final IUserService userService;

  @PostMapping("/signup")
  public ResponseEntity<UserResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
    return ResponseEntity.ok(userService.signUp(signupRequestDto));
  }

  @PostMapping("/signin")
  public ResponseEntity<String> signin(@RequestBody SignInRequestDto signinRequestDto) {
    return ResponseEntity.ok(userService.signIn(signinRequestDto));
  }
}
