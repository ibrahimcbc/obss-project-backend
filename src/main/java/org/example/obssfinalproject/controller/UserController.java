package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.example.obssfinalproject.dto.userDto.UserUpdateDto;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceView userServiceView;

    @GetMapping
    public List<UserReadDto> getAllUsers() {
        return userServiceView.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable Long id) {
        Optional<UserReadDto> userDto = userServiceView.getUserById(id);
        return userDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserReadDto createUser(@RequestBody UserRegisterDto userRegisterDto) {
        return userServiceView.createUser(userRegisterDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        return userServiceView.updateUser(id, userUpdateDto);
    }

    @PutMapping("/{id}/addToBlacklist/{blockedUserId}")
    public ResponseEntity<UserReadDto> addToBlacklist(@PathVariable Long id, @PathVariable Long blockedUserId) {
        return userServiceView.addToBlacklist(id, blockedUserId);
    }

    @PutMapping("/{id}/addToFavoritelist/{favoriteProductId}")
    public ResponseEntity<UserReadDto> addToFavorites(@PathVariable Long id, @PathVariable Long favoriteProductId) {
        return userServiceView.addToFavoriteList(id, favoriteProductId);
    }

    @PutMapping("/{id}/removeFavoritelist/{favoriteProductId}")
    public ResponseEntity<UserReadDto> removeFromFavorites(@PathVariable Long id, @PathVariable Long favoriteProductId) {
        return userServiceView.removeFromFavorites(id, favoriteProductId);
    }

    @PutMapping("/{id}/removeFromBlacklist/{blockedUserId}")
    public ResponseEntity<UserReadDto> removeFromBlacklist(@PathVariable Long id, @PathVariable Long blockedUserId) {
        return userServiceView.removeFromBlacklist(id, blockedUserId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userServiceView.deleteUser(id);
    }
}

