package com.example.user_service.service.impl;

import com.example.user_service.dto.RoleDTO;
import com.example.user_service.model.Role;
import com.example.user_service.repository.RoleRepository;
import com.example.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private RoleDTO mapToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }

    private Role mapToEntity(RoleDTO dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        return role;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = mapToEntity(roleDTO);
        Role saved = roleRepository.save(role);
        return mapToDTO(saved);
    }

    @Override
    public Optional<RoleDTO> getRoleById(Long roleId) {
        return roleRepository.findById(roleId).map(this::mapToDTO);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO updateRole(Long roleId, RoleDTO roleDTO) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (!optionalRole.isPresent()) {
            throw new RuntimeException("Role not found");
        }
        Role role = optionalRole.get();
        role.setRoleName(roleDTO.getRoleName());
        Role updated = roleRepository.save(role);
        return mapToDTO(updated);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}

