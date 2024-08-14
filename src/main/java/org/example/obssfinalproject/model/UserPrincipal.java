package org.example.obssfinalproject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
