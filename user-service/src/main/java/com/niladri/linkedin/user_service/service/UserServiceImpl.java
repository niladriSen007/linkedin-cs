package com.niladri.linkedin.user_service.service;

import org.springframework.stereotype.Service;

import com.niladri.linkedin.user_service.dto.SignInRequestDto;
import com.niladri.linkedin.user_service.dto.SignupRequestDto;
import com.niladri.linkedin.user_service.dto.UserResponseDto;
import com.niladri.linkedin.user_service.entity.User;
import com.niladri.linkedin.user_service.exceptions.UserAlreadyExists;
import com.niladri.linkedin.user_service.exceptions.UserNotFound;
import com.niladri.linkedin.user_service.repository.UserRepository;
import com.niladri.linkedin.user_service.utils.PasswordUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.niladri.linkedin.user_service.mapper.ModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final JwtService jwtService;

  @Override
  public UserResponseDto signUp(SignupRequestDto signupRequestDto) {
    User user = userRepository.findByEmail(signupRequestDto.getEmail());
    if (user != null) {
      log.error("User with email {} already exists", signupRequestDto.getEmail());
      throw new UserAlreadyExists("User with email " + signupRequestDto.getEmail() + " already exists");
    }
    String hashedPassword = PasswordUtil.hashPassword(signupRequestDto.getPassword());
    User newUser = new User();
    newUser.setName(signupRequestDto.getName());
    newUser.setEmail(signupRequestDto.getEmail());
    newUser.setPassword(hashedPassword);
    return ModelMapper.mapToUserResponseDto(userRepository.save(newUser));
  }

  @Override
  public String signIn(SignInRequestDto signinRequestDto) {
    User user = userRepository.findByEmail(signinRequestDto.getEmail());
    if (user == null) {
      log.error("User with email {} not found", signinRequestDto.getEmail());
      throw new UserNotFound("User with email " + signinRequestDto.getEmail() + " not found");
    }
    if (!PasswordUtil.verifyPassword(signinRequestDto.getPassword(), user.getPassword())) {
      log.error("Invalid password for user with email {}", signinRequestDto.getEmail());
      throw new UserAlreadyExists("Invalid password for user with email " + signinRequestDto.getEmail());
    }
    return jwtService.generateAccessToken(user);
  }

}
