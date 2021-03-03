package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.UserEntity;
import com.gunnarsson.smartlighter.io.repositories.UserRepository;
import com.gunnarsson.smartlighter.service.UserService;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity = new ModelMapper().map(user,UserEntity.class);

        userEntity.setUserId("123"); // TODO create generateId method
        userEntity.setEncryptedPassword(user.getPassword()); // TODO Create encrypted password
        UserEntity savedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        returnValue = new ModelMapper().map(savedUser,UserDto.class);

        return returnValue;
    }
}
