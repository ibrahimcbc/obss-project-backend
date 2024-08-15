package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.userDto.UserLoginDto;
import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.example.obssfinalproject.dto.userDto.UserUpdateDto;
import org.example.obssfinalproject.mapper.UserMapper;
import org.example.obssfinalproject.model.Role;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.repository.RoleRepository;
import org.example.obssfinalproject.service.UserService;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceViewImpl implements UserServiceView {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public List<UserReadDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper::toUserReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserReadDto> getUserById(Long id) {
        return userService.getUserById(id)
                .map(userMapper::toUserReadDto);

    }


    @Override
    public UserReadDto createUser(UserRegisterDto userRegisterDto) {
        try {
            User user = new User();
            user.setName(userRegisterDto.getName());
            user.setSurname(userRegisterDto.getSurname());
            user.setUsername(userRegisterDto.getUsername());
            user.setPassword(userRegisterDto.getPassword());
            user.setEmail(userRegisterDto.getEmail());

            Set<Role> roles = userRegisterDto.getRoles().stream()
                    .map(role -> roleRepository.findById(role.getId())
                            .orElseThrow(() -> new RuntimeException("Role not found: " + role.getName())))
                    .collect(Collectors.toSet());
            user.setRoles(roles);
            return userMapper.toUserReadDto(userService.createUser(user));
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<UserReadDto> updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = userMapper.toUser(userUpdateDto);
        return userService.updateUser(id, user)
                .map(userMapper::toUserReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        return userService.deleteUser(id);
    }

    @Override
    public boolean authenticateUser(UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return true;
        }
        return false;
    }
}

