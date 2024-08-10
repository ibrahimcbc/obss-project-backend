package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    ResponseEntity<User> getUserById(Long id);
    User createUser(User user);
    ResponseEntity<User> updateUser(Long id, User userDetails);
    ResponseEntity<Void> deleteUser(Long id);
}
