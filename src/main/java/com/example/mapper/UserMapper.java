package com.example.mapper;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(UserEntity userEntity);
}
