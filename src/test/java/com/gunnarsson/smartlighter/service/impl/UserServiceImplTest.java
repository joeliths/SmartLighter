package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.UserEntity;
import com.gunnarsson.smartlighter.io.repositories.UserRepository;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findUserByEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(3L);
        userEntity.setUserId("1gs8fd1hs7dgf57sga7f");
        userEntity.setEmail("joel@test.com");
        userEntity.setFirstName("Joel");
        userEntity.setEncryptedPassword("hsjdhf888a");

        when(userRepository.findUserByEmail(anyString())).thenReturn(userEntity);

        UserDto userDto = userService.findUserByEmail("joel@test.com");

        assertNotNull(userDto);
        assertEquals("Joel",userDto.getFirstName());

    }
}