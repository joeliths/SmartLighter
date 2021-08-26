package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.exceptions.UserServiceException;
import com.gunnarsson.smartlighter.io.entity.UserEntity;
import com.gunnarsson.smartlighter.io.repositories.UserRepository;
import com.gunnarsson.smartlighter.service.UserService;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import com.gunnarsson.smartlighter.ui.model.response.ErrorMessages;
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
        UserEntity userEntity = new ModelMapper().map(user,UserEntity.class);
        userEntity.setUserId(utils.generateUserId(20));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserEntity savedUser = userRepository.save(userEntity);
        return new ModelMapper().map(savedUser,UserDto.class);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        UserDto returnValue = new ModelMapper().map(userEntity,UserDto.class);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findUserByUserId(userId);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        userRepository.delete(userEntity);
    }

    @Override
    public UserDto findUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findUserByUserId(userId);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        return new ModelMapper().map(userEntity,UserDto.class);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findUserByUserId(userId);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstName(userDto.getFirstName());
        UserEntity updatedUser = userRepository.save(userEntity);
        return new ModelMapper().map(updatedUser,UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if(userEntity == null) throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
