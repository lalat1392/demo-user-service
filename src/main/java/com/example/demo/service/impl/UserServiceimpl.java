package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;


    /**
     * @param userId
     * @return
     */
    @Override
    public UserDto getUserById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())
            throw new NotFoundException(Constants.ID_NOT_FOUND, ErrorCode.NOT_FOUND);
        return userMapper.toDTO(user.get());
    }

    /**
     * @param userDto
     */
    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }
}
