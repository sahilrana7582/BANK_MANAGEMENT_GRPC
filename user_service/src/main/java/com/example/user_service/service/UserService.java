package com.example.user_service.service;


import com.example.user_service.dto.UserRequestDTO;
import com.example.user_service.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRequestDTO userDTO);
    void deleteUser(Long id);
}
