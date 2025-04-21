package com.example.account_service.mapper;


import com.example.account_service.dto.AccountRequestDTO;
import com.example.account_service.dto.AccountResponseDTO;
import com.example.account_service.entity.Account;

public class AccountMapper {

    public static Account toEntity(AccountRequestDTO dto) {
        Account account = new Account();
        account.setUser_id(dto.getUserId());
        account.setAccount_type(dto.getAccountType());
        account.setBalance(dto.getBalance());
        account.setAccountHolderName(dto.getAccountHolderName());
        return account;
    }

    public static AccountResponseDTO toDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setAccountId(account.getAccount_id());
        dto.setUserId(account.getUser_id());
        dto.setAccountType(account.getAccount_type());
        dto.setBalance(account.getBalance());
        dto.setAccountHolderName(account.getAccountHolderName());
        return dto;
    }
}

