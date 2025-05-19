package com.example.user_service.repository;


import com.example.user_service.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByRole_RoleId(Long roleId);
    List<UserRole> findByUser_UserId(Long userId);
}

