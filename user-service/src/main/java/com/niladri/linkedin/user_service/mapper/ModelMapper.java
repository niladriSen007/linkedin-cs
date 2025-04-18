package com.niladri.linkedin.user_service.mapper;

import com.niladri.linkedin.user_service.dto.UserResponseDto;
import com.niladri.linkedin.user_service.entity.User;

public class ModelMapper {
    public static UserResponseDto mapToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }

    public static User mapToUser(UserResponseDto userResponseDto) {
        User user = new User();
        user.setId(userResponseDto.getId());
        user.setName(userResponseDto.getName());
        user.setEmail(userResponseDto.getEmail());
        return user;
    }
}
