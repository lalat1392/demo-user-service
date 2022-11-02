package com.example.demo.service.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceimpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceimpl userServiceimpl;

    @Mock
    UserRepository userRepository;
   
    @Mock
    UserMapper userMapper;
    
    private User user;
    
    private UserDto userDto;
    
    @BeforeEach
    public void setup(){
    	user =new User();
    	user.setId(1);
    	user.setFirstName("jam");
    	user.setLastName("ohara");
    	user.setEmail("jam@email.com");
        userDto =new UserDto();
        BeanUtils.copyProperties(user, userDto);
    }


    @Test
    public void getUserById() {
    	when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
    	when(userMapper.toDTO(Optional.of(user).get())).thenReturn(userDto);
    	UserDto userById = userServiceimpl.getUserById(user.getId());
    	assertThat(userById.getEmail()).isEqualTo("jam@email.com");
    	assertThat(userById).isNotNull();
    };
    
    @Test
    public void getUserById_whenUserNotFound() {
    	when(userRepository.findById(2)).thenReturn(Optional.empty());
    	NotFoundException assertThrows = org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class,()->{
    		userServiceimpl.getUserById(2);
    	});
    	assertThat(assertThrows.getMessage()).isEqualTo(" Not Found");
    };

    @Test
    public void getAllUsers() throws Exception {
    	
    	when(userRepository.findAll()).thenReturn(List.of(user,user));
    	List<UserDto> allUsers = userServiceimpl.getAllUsers();
    	assertThat(allUsers).isNotEmpty();
    	assertThat(allUsers.size()).isEqualTo(2);
    	
    }

    @Test
    public void saveUser() throws Exception {
    	 when(userRepository.save(userMapper.toEntity(userDto))).thenReturn(user);
    	 userServiceimpl.saveUser(userDto);
    }
}
