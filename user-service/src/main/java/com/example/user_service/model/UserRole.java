package com.example.user_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles", schema = "food_delivery")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Getters and setters
    public Long getUserRoleId() { return userRoleId; }
    public void setUserRoleId(Long userRoleId) { this.userRoleId = userRoleId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}

