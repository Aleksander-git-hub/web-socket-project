package com.example.service.impl;

import com.example.dto.PasswordDto;
import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity registerUser(UserDto newUser) {
        // validation
        return null;
    }

    @Override
    public UserEntity findUserByLogin(String login) {
        return null;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return null;
    }

    @Override
    public void activateUser(String code) {

    }

    @Override
    public UserEntity updateUser(UserDto user) {
        return null;
    }

    @Override
    public UserEntity changePassword(PasswordDto passwordDto) {
        return null;
    }
}
