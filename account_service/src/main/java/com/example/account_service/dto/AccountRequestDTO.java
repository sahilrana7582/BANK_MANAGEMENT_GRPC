package com.example.account_service.dto;


import lombok.Data;

@Data
public class AccountRequestDTO {
    private Long userId;
    private String accountType;
    private Double balance;
    private String accountHolderName;
}
