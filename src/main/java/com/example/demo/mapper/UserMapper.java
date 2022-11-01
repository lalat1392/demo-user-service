package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class UserMapper implements BaseMapper<User, UserDto> {

    @Override
    public User toEntity(UserDto dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public UserDto toDTO(User entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
