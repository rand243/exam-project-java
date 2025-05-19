package com.example.user_service.service.impl;

import com.example.user_service.dto.UserRoleDTO;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import com.example.user_service.model.UserRole;
import com.example.user_service.repository.RoleRepository;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.repository.UserRoleRepository;
import com.example.user_service.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,
                               UserRepository userRepository,
                               RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    private UserRoleDTO mapToDTO(UserRole userRole) {
        UserRoleDTO dto = new UserRoleDTO();
        dto.setUserRoleId(userRole.getUserRoleId());
        dto.setUserId(userRole.getUser().getUserId());
        dto.setRoleId(userRole.getRole().getRoleId());
        return dto;
    }

    private UserRole mapToEntity(UserRoleDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        return userRole;
    }

    @Override
    public UserRoleDTO assignRoleToUser(UserRoleDTO dto) {
        UserRole entity = mapToEntity(dto);
        UserRole saved = userRoleRepository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public List<UserRoleDTO> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUser_UserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> getUsersByRoleId(Long roleId) {
        return userRoleRepository.findByRole_RoleId(roleId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserRole(Long userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }


}

