package org.example.obssfinalproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.obssfinalproject.model.products.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String name;
    private String surname;
    private String password;
    private String email;

    @Column(unique = true)
    private String username;

    private double balance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @ElementCollection
    private List<Long> followers;

    @ElementCollection
    private List<Long> favoriteList;

    @ElementCollection
    private List<Long> blackList;

    @ElementCollection
    private List<Long> recommendedProduct;
}

