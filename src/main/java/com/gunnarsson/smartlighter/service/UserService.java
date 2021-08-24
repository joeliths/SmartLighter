package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto findUserByEmail(String email);
    void deleteUser(String userId);
    UserDto findUserByUserId(String userId);
    UserDto updateUser(String userID, UserDto userDto);
}
