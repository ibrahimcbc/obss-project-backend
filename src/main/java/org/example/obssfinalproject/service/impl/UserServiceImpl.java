package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.model.Role;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.UserPrincipal;
import org.example.obssfinalproject.repository.RoleRepository;
import org.example.obssfinalproject.repository.UserRepository;
import org.example.obssfinalproject.service.RoleService;
import org.example.obssfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<Role> roles = roleService.getRoles();
        for(Role role: roles) {
            role.getUsers().forEach(user -> {
                Set<Role> r = new HashSet<>();
                Role role1 = new Role();
                role1.setId(role.getId());
                role1.setName(role.getName());
                r.add(role1);
                user.setRoles(r);
            });
        }
        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            List<Role> roles = roleService.getRoles();
            roles.forEach(role -> {
                role.getUsers().forEach(user1 -> {
                    if (user1.getId() == id){
                        Set<Role> r = new HashSet<>();
                        Role role1 = new Role();
                        role1.setId(role.getId());
                        role1.setName(role.getName());
                        r.add(role1);
                        user.get().setRoles(r);
                    }
                });
            });
        }
        return user;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User existingUser = user.get();

            // Name alanı boş değilse güncelle
            if (userDetails.getName() != null && !userDetails.getName().isEmpty()) {
                existingUser.setName(userDetails.getName());
            }

            // Surname alanı boş değilse güncelle
            if (userDetails.getSurname() != null && !userDetails.getSurname().isEmpty()) {
                existingUser.setSurname(userDetails.getSurname());
            }

            // Password alanı boş değilse güncelle
            if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                existingUser.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
            }

            // Email alanı boş değilse güncelle
            if (userDetails.getEmail() != null && !userDetails.getEmail().isEmpty()) {
                existingUser.setEmail(userDetails.getEmail());
            }

            // Username alanı boş değilse güncelle
            if (userDetails.getUsername() != null && !userDetails.getUsername().isEmpty()) {
                existingUser.setUsername(userDetails.getUsername());
            }

            // Balance alanı null değilse güncelle
            if (userDetails.getBalance() != 0) {
                existingUser.setBalance(userDetails.getBalance());
            }

            // Roles alanı boş değilse güncelle
            if (userDetails.getRoles() != null && !userDetails.getRoles().isEmpty()) {
                existingUser.setRoles(userDetails.getRoles());
            }

            // Followers alanı boş değilse güncelle
            if (userDetails.getFollowers() != null && !userDetails.getFollowers().isEmpty()) {
                existingUser.setFollowers(userDetails.getFollowers());
            }

            // FavoriteList alanı boş değilse güncelle
            if (userDetails.getFavoriteList() != null && !userDetails.getFavoriteList().isEmpty()) {
                existingUser.setFavoriteList(userDetails.getFavoriteList());
            }

            // BlackList alanı boş değilse güncelle
            if (userDetails.getBlackList() != null && !userDetails.getBlackList().isEmpty()) {
                existingUser.setBlackList(userDetails.getBlackList());
            }

            // RecommendedProduct alanı boş değilse güncelle
            if (userDetails.getRecommendedProduct() != null && !userDetails.getRecommendedProduct().isEmpty()) {
                existingUser.setRecommendedProduct(userDetails.getRecommendedProduct());
            }

            return Optional.of(userRepository.save(existingUser));
        } else {
            throw new RuntimeException("User not found");
        }
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
    public Optional<User> addToBlacklist(Long id, Long blockedUserId) {
        Optional<User> user = userRepository.findById(id);
        Optional<User> blockedUser = userRepository.findById(blockedUserId);
        if (user.isPresent() && blockedUser.isPresent()){
            user.get().getBlackList().add(blockedUser.get().getId());
            return Optional.of(userRepository.save(user.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> addToFavoriteList(Long id, Long favoriteProductId) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().getFavoriteList().add(favoriteProductId);
            return Optional.of(userRepository.save(user.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> addToRecommendedProduct(Long id, Long productId) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().getRecommendedProduct().add(productId);
            return Optional.of(userRepository.save(user.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> followUser(Long id, Long followedUserId) {
        Optional<User> user = userRepository.findById(id);
        Optional<User> followedUser = userRepository.findById(followedUserId);
        if (user.isPresent() && followedUser.isPresent()){
            followedUser.get().getFollowers().add(user.get().getId());
            return Optional.of(userRepository.save(followedUser.get()));
        }
        return Optional.empty();
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
