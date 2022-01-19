package com.example.service.impl;

import com.example.dto.PasswordDto;
import com.example.dto.UserDto;
import com.example.email.CustomMailSender;
import com.example.entity.UserEntity;
import com.example.entity.enums.Status;
import com.example.repository.UserRepository;
import com.example.service.MessageGenerator;
import com.example.service.UserService;
import com.example.service.validation.InfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InfoValidator infoValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomMailSender mailSender;

    @Autowired
    private MessageGenerator messageGenerator;

    @Override
    public UserEntity registerUser(UserDto user) {
        infoValidator.registerValidator(user);
        infoValidator.emailValidator(user.getEmail());
        infoValidator.forbiddenLogin(user.getLogin());
        infoValidator.forbiddenEmail(user.getEmail());
        UserEntity userEntity = UserEntity.builder()
                .login(user.getLogin())
                .password(passwordEncoder.encode(user.getPassword()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .created(new Date())
                .update(new Date())
                .status(Status.NOT_CONFIRMED)
                .activationCode(messageGenerator.generateActivationCode())
                .build();
        userRepository.save(userEntity);
        mailSender.send(
                user.getEmail(),
                "Activation code",
                messageGenerator.getRegistrationMessage(userEntity));
        return userEntity;
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
