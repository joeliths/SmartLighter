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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity = new ModelMapper().map(user,UserEntity.class);
        userEntity.setUserId(utils.generateUserId(20));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserEntity savedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        returnValue = new ModelMapper().map(savedUser,UserDto.class);

        return returnValue;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if(userEntity== null) throw new UsernameNotFoundException(email);
        UserDto returnValue = new ModelMapper().map(userEntity,UserDto.class);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findUserByUserId(userId);
        userRepository.delete(userEntity);
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findUserByUserId(userId);
        return new ModelMapper().map(userEntity,UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if(userEntity== null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
