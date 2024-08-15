package org.example.obssfinalproject.dto.userDto;

import lombok.Data;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.products.Product;

import java.util.List;
import java.util.Set;

@Data
public class UserUpdateDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
    private List<Long> followers;
    private List<Long> favoriteList;
    private List<Long> blackList;
    private List<Long> recommendedProduct;
    private double balance;
}
