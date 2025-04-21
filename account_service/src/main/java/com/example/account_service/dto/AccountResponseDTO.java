package com.example.account_service.dto;


import lombok.Data;

@Data
public class AccountResponseDTO {
    private Long accountId;
    private Long userId;
    private String accountType;
    private Double balance;
    private String accountHolderName;
}
