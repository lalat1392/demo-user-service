package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = Constants.GET_USER_BY_ID)
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Integer userId) {
        return ResponseUtil.getResponse(OK, Constants.SUCCESS, userService.getUserById(userId));
    }

    @GetMapping(value = Constants.GET_ALL_USERS)
    public ResponseEntity<ApiResponse> getAllUsers() {
        return ResponseUtil.getResponse(OK, Constants.SUCCESS, userService.getAllUsers());
    }

    @PostMapping(value = Constants.SAVE_USER)
    public ResponseEntity<ApiResponse> saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseUtil.getResponse(OK, Constants.SUCCESS);
    }
}
