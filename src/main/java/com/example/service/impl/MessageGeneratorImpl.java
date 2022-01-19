package com.example.service.impl;

import com.example.entity.UserEntity;
import com.example.service.MessageGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    @Override
    public String generateActivationCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getRegistrationMessage(UserEntity user) {
        return String.format(
                "Hello, %s!\n" +
                        "Welcome to FriendsChat! Please, visit next link:\n " +
                        "http://%s/friends-room/api/v1/activate/%s",
                user.getFirstName(),
                user.getActivationCode()
        );
    }
}
