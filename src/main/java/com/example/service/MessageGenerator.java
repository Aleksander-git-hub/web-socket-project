package com.example.service;

import com.example.entity.UserEntity;

public interface MessageGenerator {

    String generateActivationCode();

    String getRegistrationMessage(UserEntity user);
}
