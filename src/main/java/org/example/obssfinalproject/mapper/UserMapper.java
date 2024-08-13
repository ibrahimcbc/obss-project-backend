package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.userDto.UserLoginDto;
import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.example.obssfinalproject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserReadDto toUserReadDto(User user) {
        UserReadDto dto = new UserReadDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles());
        dto.setFollowers(user.getFollowers());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User toUser(UserRegisterDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setRoles(dto.getRoles());
        return user;
    }

    public UserLoginDto toUserLoginDto(User user) {
        UserLoginDto dto = new UserLoginDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }
}

