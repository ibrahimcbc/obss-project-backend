package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.User;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    Optional<User> updateUser(Long id, User userDetails);
    ResponseEntity<Void> deleteUser(Long id);
}
