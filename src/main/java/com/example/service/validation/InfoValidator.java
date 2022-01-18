package com.example.service.validation;

import com.example.dto.UserDto;

public interface InfoValidator {

    void registerValidator(UserDto userDto);

    void emailValidator(String email);

    void forbiddenLogin(String login);

    void forbiddenEmail(String email);
}
