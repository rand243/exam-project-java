package com.example.user_service.service;


import com.example.user_service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    Optional<UserDTO> getUserById(Long userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
}


