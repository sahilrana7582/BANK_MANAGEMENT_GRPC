package com.example.user_service.dto;


import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
