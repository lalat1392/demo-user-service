package com.example.demo.Controller;


import com.example.demo.controller.UserController;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserById() throws Exception {
        String URI = "/user" + Constants.GET_USER_BY_ID;
        when(userService.getUserById(1)).thenReturn(userDto());
        mockMvc.perform(MockMvcRequestBuilders.get(URI, 1))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("SUCCESS"))
                .andExpect(status().isOk());

    }

    private UserDto userDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setEmail("avc");
        userDto.setFirstName("a");
        userDto.setLastName("b");
        return userDto;
    }

    @Test
    public void getAllUsers() throws Exception {
        String URI = "/user" + Constants.GET_ALL_USERS;
        when(userService.getAllUsers()).thenReturn(newArrayList(userDto()));
        mockMvc.perform(MockMvcRequestBuilders.get(URI))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("SUCCESS"));

    }


    @Test
    public void saveUser() throws Exception {
        String URI = "/user" + Constants.SAVE_USER;
        doNothing().when(userService).saveUser(userDto());
        mockMvc.perform(MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"firstName\": \"a\", \"lastName\": \"b\",\"email\": \"e\"}"))
                .andExpect(status().isOk());

    }
}
