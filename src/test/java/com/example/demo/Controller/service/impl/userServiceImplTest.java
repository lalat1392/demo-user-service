package com.example.demo.Controller.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class userServiceImplTest {

    @InjectMocks
    private UserServiceimpl userServiceimpl;

    @MockBean
    UserRepository userRepository;


    @Test
    public void getUserById() {

    }

    @Test
    public void getAllUsers() throws Exception {

    }

    @Test
    public void saveUser() throws Exception {

    }
}
