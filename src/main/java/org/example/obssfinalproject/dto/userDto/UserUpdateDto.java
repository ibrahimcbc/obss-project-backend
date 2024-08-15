package org.example.obssfinalproject.dto.userDto;

import lombok.Data;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.products.Product;

import java.util.Set;

@Data
public class UserUpdateDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
    private Set<User> followers;
    private Set<Product> favoriteList;
    private Set<User> blackList;
    private Set<Product> recommendedProduct;
    private double balance;
}
