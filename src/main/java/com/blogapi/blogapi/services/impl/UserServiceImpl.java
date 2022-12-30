package com.blogapi.blogapi.services.impl;

import com.blogapi.blogapi.entities.User;
import com.blogapi.blogapi.payloads.UserDto;
import com.blogapi.blogapi.repositories.UserRepo;
import com.blogapi.blogapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
         return this.userToDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow((e-> new ResourceNotFoundException("User"," id ",userId)))
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

     }
    private User dtoToUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout((userDto.getAbout()));
        user.setPassword(userDto.getPassword());
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(userDto.getId());
        userDto.setName(userDto.getName());
        userDto.setEmail(userDto.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(userDto.getPassword());
        return userDto;
    }
}
