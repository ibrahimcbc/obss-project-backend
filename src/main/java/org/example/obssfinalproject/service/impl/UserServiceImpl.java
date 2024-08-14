package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.UserPrincipal;
import org.example.obssfinalproject.repository.UserRepository;
import org.example.obssfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

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
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }
}
