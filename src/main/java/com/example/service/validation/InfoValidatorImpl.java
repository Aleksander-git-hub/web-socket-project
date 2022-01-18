package com.example.service.validation;

import com.example.dto.UserDto;
import com.example.exceptions.NotFoundException;
import com.example.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InfoValidatorImpl implements InfoValidator {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public void emailValidator(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new NotFoundException("Email entered incorrectly!");
        }
    }

    @Override
    public void forbiddenLogin(String login) {
        if (userRepository.findByLogin(login) != null) {
            String message =
                    String.format("User with this login %s already exist!", login);
            throw new NotFoundException(message);
        }
    }

    @Override
    public void forbiddenEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            String message =
                    String.format("User with this email %s already exist!", email);
            throw new NotFoundException(message);
        }
    }
}
