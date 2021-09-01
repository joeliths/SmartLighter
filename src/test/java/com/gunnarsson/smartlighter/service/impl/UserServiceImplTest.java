package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.exceptions.UserServiceException;
import com.gunnarsson.smartlighter.io.entity.UserEntity;
import com.gunnarsson.smartlighter.io.repositories.UserRepository;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    Utils utils;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    UserEntity userEntity = new UserEntity();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userEntity.setId(3L);
        userEntity.setUserId("1gs8fd1hs7dgf57sga7f");
        userEntity.setEmail("joel@test.com");
        userEntity.setFirstName("Joel");
        userEntity.setEncryptedPassword("hsjdhf888a");
    }

    @Test
    void findUserByEmail() {
        when(userRepository.findUserByEmail(anyString())).thenReturn(userEntity);

        UserDto userDto = userService.findUserByEmail("joel@test.com");

        assertNotNull(userDto);
        assertEquals("Joel",userDto.getFirstName());
    }

    @Test
    void FindUserByEmail_UserServiceException(){
        when(userRepository.findUserByEmail(anyString())).thenReturn(null);

        assertThrows(UserServiceException.class, ()->{
            userService.findUserByEmail("joel@test.com");
        });
    }

    @Test
    void CreateUser(){
        when(utils.generateUserId(anyInt())).thenReturn(userEntity.getUserId());
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn(userEntity.getEncryptedPassword());
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setPassword("test");


        UserDto savedUser = userService.createUser(userDto);

        assertNotNull(savedUser);
        assertEquals(userEntity.getFirstName(),savedUser.getFirstName());
        assertEquals(userEntity.getEmail(),savedUser.getEmail());
        assertEquals(userEntity.getEncryptedPassword(),savedUser.getEncryptedPassword());
        assertEquals(userEntity.getUserId(),savedUser.getUserId());
    }
}