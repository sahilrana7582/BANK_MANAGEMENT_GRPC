package com.example.user_service.grpc;

import com.example.bank.proto.account.AccountCreateRequest;
import com.example.bank.proto.account.AccountCreateResponse;
import com.example.bank.proto.account.AccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountGrpcClient {

    private final AccountServiceGrpc.AccountServiceBlockingStub accountStub;

    public AccountGrpcClient() {
        // Make sure to use plaintext if you're not using TLS
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("account_service", 9099)
                .usePlaintext()
                .build();

        this.accountStub = AccountServiceGrpc.newBlockingStub(channel);
    }

    public void createAccount() {
        try {
            AccountCreateRequest request = AccountCreateRequest.newBuilder()
                    .setUserId(1L)
                    .setAccountType("Savings")
                    .setBalance(1000.0)
                    .setAccountHolderName("John Doe")
                    .build();

            AccountCreateResponse response = accountStub.createAccount(request);

            log.info("✅ Account created with ID: {}", response.getAccountId());
        } catch (StatusRuntimeException e) {
            log.error("❌ gRPC request failed: {}", e.getStatus(), e);
        }
    }
}
