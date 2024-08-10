package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserServiceView {

    List<UserReadDto> getAllUsers();
    ResponseEntity<UserReadDto> getUserById(Long id);
    UserReadDto createUser(UserRegisterDto userRegisterDto);
    ResponseEntity<UserReadDto> updateUser(Long id, UserRegisterDto userRegisterDto);
    ResponseEntity<Void> deleteUser(Long id);
}
