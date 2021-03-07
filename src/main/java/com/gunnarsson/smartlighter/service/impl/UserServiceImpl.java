package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.UserEntity;
import com.gunnarsson.smartlighter.io.repositories.UserRepository;
import com.gunnarsson.smartlighter.service.UserService;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity = new ModelMapper().map(user,UserEntity.class);

        userEntity.setUserId(utils.generateUserId(20));
        userEntity.setEncryptedPassword(user.getPassword()); // TODO Create encrypted password
        UserEntity savedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        returnValue = new ModelMapper().map(savedUser,UserDto.class);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if(userEntity== null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
