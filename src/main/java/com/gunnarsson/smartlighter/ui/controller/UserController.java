package com.gunnarsson.smartlighter.ui.controller;

import com.gunnarsson.smartlighter.service.UserService;
import com.gunnarsson.smartlighter.shared.dto.UserDto;
import com.gunnarsson.smartlighter.ui.model.request.UserRequestModel;
import com.gunnarsson.smartlighter.ui.model.response.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponseModel> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        Type listType = new TypeToken<List<UserResponseModel>>(){}.getType();
        return new ModelMapper().map(users,listType);
    }

    @GetMapping(path = "/{id}")
    public UserResponseModel findUserById(@PathVariable String id){
        UserDto userDto = userService.findUserByUserId(id);
        return new ModelMapper().map(userDto,UserResponseModel.class);
    }

    @PostMapping
    public UserResponseModel createUser(@RequestBody UserRequestModel userRequestModel){
        UserDto userDto = new ModelMapper().map(userRequestModel,UserDto.class);
        UserDto createdUser = userService.createUser(userDto);
        return new ModelMapper().map(createdUser,UserResponseModel.class);
    }


    @PutMapping(path = "/{id}")
    public UserResponseModel updateUser(@PathVariable String id, @RequestBody UserRequestModel userRequestModel){
        UserDto userDto = new ModelMapper().map(userRequestModel,UserDto.class);
        UserDto updatedUser = userService.updateUser(id,userDto);
        return new ModelMapper().map(updatedUser,UserResponseModel.class);
    }

    @DeleteMapping(path = "/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable(value = "id") String userId){
        userService.deleteUser(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put(userId, Boolean.TRUE);
        return response;
    }
}
