package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;

public interface UserService {

    UserEntity registerUser(UserDto userDto);
}
