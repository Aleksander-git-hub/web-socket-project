package com.example.service.impl;

import com.example.dto.PasswordDto;
import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.service.validation.InfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InfoValidator infoValidator;

    @Override
    public UserEntity registerUser(UserDto user) {
        infoValidator.registerValidator(user);
        infoValidator.emailValidator(user.getEmail());
        infoValidator.forbiddenLogin(user.getLogin());
        infoValidator.forbiddenEmail(user.getEmail());
        UserEntity userEntity = UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
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
