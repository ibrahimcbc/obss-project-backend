package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.userDto.UserLoginDto;
import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.service.impl.JwtService;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserServiceView userServiceView;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLoginDto userLoginDto) {
        boolean isAuthenticated = userServiceView.authenticateUser(userLoginDto);
        UserReadDto user = userServiceView.getAllUsers().stream()
                .filter(u -> u.getUsername().equals(userLoginDto.getUsername()))
                .findFirst()
                .orElse(null);
        Long id = user.getId();
        String roleName = user.getRoles().stream().findFirst().get().getName();
        if (isAuthenticated) {
            String token = jwtService.generateToken(userLoginDto.getUsername(),id,roleName); // JWT token oluşturuluyor
            // JSON formatında yanıt oluşturmak için Map kullanıyoruz
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", token);

            return ResponseEntity.ok(response); // JSON yanıtı döndürülüyor
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Unauthorized"));
        }
    }
}