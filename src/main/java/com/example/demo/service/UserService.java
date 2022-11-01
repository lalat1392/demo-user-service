package com.example.demo.service;


import com.example.demo.dto.UserDto;

import java.util.List;


public interface UserService {

    /**
     * @param userId
     * @return
     */
    UserDto getUserById(Integer userId);

    /**
     * @param userDto
     */
    void saveUser(UserDto userDto);

    /**
     * @return
     */
    List<UserDto> getAllUsers();
}
