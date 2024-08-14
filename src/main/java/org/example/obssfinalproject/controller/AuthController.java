package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.userDto.UserLoginDto;
import org.example.obssfinalproject.service.impl.JwtService;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserServiceView userServiceView;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        boolean isAuthenticated = userServiceView.authenticateUser(userLoginDto);
        if (isAuthenticated) {
            String token = jwtService.generateToken(userLoginDto.getUsername());
            return ResponseEntity.ok("Login successful : " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("seaase");
        }
    }
}