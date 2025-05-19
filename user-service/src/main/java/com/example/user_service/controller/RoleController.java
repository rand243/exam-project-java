package com.example.user_service.controller;

import com.example.user_service.dto.RoleDTO;
import com.example.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
        return roleService.createRole(roleDTO);
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(id, roleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}

