package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.model.Role;
import org.example.obssfinalproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping()
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @GetMapping()
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
