package org.example.obssfinalproject.dto.userDto;

import lombok.Data;
import org.example.obssfinalproject.model.Role;

import java.util.Set;

@Data
public class UserRegisterDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
    private Set<Role> roles;
}
