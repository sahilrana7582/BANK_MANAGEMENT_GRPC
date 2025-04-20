package com.example.user_service.mapper;

import com.example.user_service.dto.UserRequestDTO;
import com.example.user_service.dto.UserResponseDTO;
import com.example.user_service.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserRequestDTO userRequestDTO){
        return UserEntity.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .address(userRequestDTO.getAddress())
                .phoneNumber(userRequestDTO.getPhoneNumber())
                .build();
    }


    public static UserResponseDTO toDTO(UserEntity user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }
}
