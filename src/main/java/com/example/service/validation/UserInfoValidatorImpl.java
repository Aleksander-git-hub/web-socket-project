package com.example.service.validation;

import com.example.dto.UserDto;
import com.example.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserInfoValidatorImpl implements UserInfoValidator {
    @Override
    public void registerValidator(UserDto userDto) {
        if (StringUtils.isEmpty(userDto.getEmail()) ||
            StringUtils.isEmpty(userDto.getFirstName()) ||
            StringUtils.isEmpty(userDto.getLastName()) ||
            StringUtils.isEmpty(userDto.getLogin()) ||
            StringUtils.isEmpty(userDto.getPassword()) ||
            StringUtils.isEmpty(userDto.getConfirmPassword())) {
            throw new NotFoundException("Some fields are empty! Please, check this!");
        }
    }
}
