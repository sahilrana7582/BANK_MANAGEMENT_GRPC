package com.example.account_service.Grpc;

import com.example.bank.proto.user.User;
import com.example.bank.proto.user.UserRequest;
import com.example.bank.proto.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserGrpcClient {

    private final UserServiceGrpc.UserServiceBlockingStub userStub;

    public UserGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090) // IP of user-service
                .usePlaintext()
                .build();

        this.userStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public User getUser(String name) {
        UserRequest request = UserRequest.newBuilder()
                .setName(name)
                .setEmail("example@example.com")
                .setPassword("password123")
                .setAddress("1234 Street, City")
                .setPhoneNumber("9876543210")
                .build();

        return userStub.getUser(request);
    }
}
