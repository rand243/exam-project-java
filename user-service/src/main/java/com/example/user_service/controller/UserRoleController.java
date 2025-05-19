package com.example.user_service.controller;

import com.example.user_service.dto.UserRoleDTO;
import com.example.user_service.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public UserRoleDTO assignRoleToUser(@RequestBody UserRoleDTO dto) {
        return userRoleService.assignRoleToUser(dto);
    }

    @GetMapping("/user/{userId}")
    public List<UserRoleDTO> getRolesByUserId(@PathVariable Long userId) {
        return userRoleService.getRolesByUserId(userId);
    }

    @GetMapping("/role/{roleId}")
    public List<UserRoleDTO> getUsersByRoleId(@PathVariable Long roleId) {
        return userRoleService.getUsersByRoleId(roleId);
    }

    @DeleteMapping("/{userRoleId}")
    public void deleteUserRole(@PathVariable Long userRoleId) {
        userRoleService.deleteUserRole(userRoleId);
    }


}

