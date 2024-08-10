package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.repository.UserRepository;
import org.example.obssfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok().body(user);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setUsername(userDetails.getUsername());
        user.setBalance(userDetails.getBalance());
        user.setRoles(userDetails.getRoles());
        user.setFollowers(userDetails.getFollowers());
        user.setFavoriteList(userDetails.getFavoriteList());
        user.setBlackList(userDetails.getBlackList());
        user.setRecommendedProduct(userDetails.getRecommendedProduct());

        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
