package com.example.service;

import com.example.dto.PasswordDto;
import com.example.dto.UserDto;
import com.example.entity.UserEntity;

public interface UserService {

    UserEntity registerUser(UserDto newUser);

    UserEntity findUserByLogin(String login);

    UserEntity findUserByEmail(String email);

    void activateUser(String code);

    UserEntity updateUser(UserDto user);

    UserEntity changePassword(PasswordDto passwordDto);

}
