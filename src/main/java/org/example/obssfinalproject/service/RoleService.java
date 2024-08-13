package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRole(Long id);
    List<Role> getRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
