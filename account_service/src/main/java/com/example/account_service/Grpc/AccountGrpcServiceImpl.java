package com.example.account_service.Grpc;

import com.example.account_service.dto.AccountRequestDTO;
import com.example.account_service.dto.AccountResponseDTO;
import com.example.account_service.service.AccountService;
import com.example.bank.proto.account.AccountCreateRequest;
import com.example.bank.proto.account.AccountCreateResponse;
import com.example.bank.proto.account.AccountServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@GrpcService
@RequiredArgsConstructor
@Slf4j
public class AccountGrpcServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {

    @Autowired
    private  AccountService accountService;

    @Override
    public void createAccount(AccountCreateRequest request, StreamObserver<AccountCreateResponse> responseObserver) {
        try{
            AccountRequestDTO requestDTO = new AccountRequestDTO();
            requestDTO.setUserId(request.getUserId());
            requestDTO.setAccountType(request.getAccountType());
            requestDTO.setBalance(request.getBalance());
            requestDTO.setAccountHolderName(request.getAccountHolderName());

            AccountResponseDTO responseDTO = accountService.createAccount(requestDTO);

            AccountCreateResponse response = AccountCreateResponse.newBuilder()
                    .setAccountId(responseDTO.getAccountId())
                    .setAccountType(responseDTO.getAccountType())
                    .setAccountHolderName(responseDTO.getAccountHolderName())
                    .setBalance(responseDTO.getBalance())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch (Exception e){
            log.info("Error creating account: {}", e.getMessage());
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription("Failed to create account: " + e.getMessage())
                            .augmentDescription(e.toString())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }
}
