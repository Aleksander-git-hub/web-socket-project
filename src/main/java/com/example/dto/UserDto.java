package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
}
