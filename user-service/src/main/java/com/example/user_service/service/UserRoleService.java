package com.example.user_service.service;

import com.example.user_service.dto.UserRoleDTO;

import java.util.List;

public interface UserRoleService {


    UserRoleDTO assignRoleToUser(UserRoleDTO userRoleDTO);
    List<UserRoleDTO> getRolesByUserId(Long userId);
    List<UserRoleDTO> getUsersByRoleId(Long roleId);
    void deleteUserRole(Long userRoleId);
}

