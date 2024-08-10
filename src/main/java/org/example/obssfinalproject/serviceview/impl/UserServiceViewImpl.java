package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.example.obssfinalproject.mapper.UserMapper;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.service.UserService;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceViewImpl implements UserServiceView {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserReadDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper::toUserReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UserReadDto> getUserById(Long id) {
        return userService.getUserById(id)
                .map(userMapper::toUserReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public UserReadDto createUser(UserRegisterDto userRegisterDto) {
        User user = userMapper.toUser(userRegisterDto);
        User createdUser = userService.createUser(user);
        return userMapper.toUserReadDto(createdUser);
    }

    @Override
    public ResponseEntity<UserReadDto> updateUser(Long id, UserRegisterDto userRegisterDto) {
        User user = userMapper.toUser(userRegisterDto);
        return userService.updateUser(id, user)
                .map(userMapper::toUserReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}

