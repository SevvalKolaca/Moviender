package com.moviender.moviender.user.service;

import com.moviender.moviender.user.dto.UserCreateDto;
import com.moviender.moviender.user.dto.UserResponseDto;
import com.moviender.moviender.user.dto.UserUpdateDto;
import com.moviender.moviender.user.model.User;

import java.util.UUID;

public interface UserService {
    UserResponseDto createUser(UserCreateDto createDto);
    void updateUser(UUID id, UserUpdateDto updateDto);
}
