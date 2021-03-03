package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
