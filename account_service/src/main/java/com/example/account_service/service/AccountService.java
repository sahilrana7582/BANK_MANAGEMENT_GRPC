package com.example.account_service.service;



import com.example.account_service.dto.AccountRequestDTO;
import com.example.account_service.dto.AccountResponseDTO;
import com.example.account_service.entity.Account;
import com.example.account_service.mapper.AccountMapper;
import com.example.account_service.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {
        Account account = AccountMapper.toEntity(requestDTO);
        Account saved = accountRepository.save(account);
        return AccountMapper.toDTO(saved);
    }

    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AccountResponseDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        return AccountMapper.toDTO(account);
    }

    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO requestDTO) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        account.setUser_id(requestDTO.getUserId());
        account.setAccount_type(requestDTO.getAccountType());
        account.setBalance(requestDTO.getBalance());
        account.setAccountHolderName(requestDTO.getAccountHolderName());

        return AccountMapper.toDTO(accountRepository.save(account));
    }

    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new EntityNotFoundException("Account not found");
        }
        accountRepository.deleteById(id);
    }
}

