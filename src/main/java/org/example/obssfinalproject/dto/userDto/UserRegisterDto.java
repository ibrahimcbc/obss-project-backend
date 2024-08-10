package org.example.obssfinalproject.dto.userDto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
}
