package com.example.user_service.service;

import com.example.user_service.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDTO createRole(RoleDTO roleDTO);
    Optional<RoleDTO> getRoleById(Long roleId);
    List<RoleDTO> getAllRoles();
    RoleDTO updateRole(Long roleId, RoleDTO roleDTO);
    void deleteRole(Long roleId);
}

