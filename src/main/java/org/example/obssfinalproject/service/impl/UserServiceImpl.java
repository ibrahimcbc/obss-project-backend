package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.repository.UserRepository;
import org.example.obssfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userDetails.getName());
            existingUser.setSurname(userDetails.getSurname());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setBalance(userDetails.getBalance());
            existingUser.setRoles(userDetails.getRoles());
            existingUser.setFollowers(userDetails.getFollowers());
            existingUser.setFavoriteList(userDetails.getFavoriteList());
            existingUser.setBlackList(userDetails.getBlackList());
            existingUser.setRecommendedProduct(userDetails.getRecommendedProduct());
            return userRepository.save(existingUser);
        });
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
