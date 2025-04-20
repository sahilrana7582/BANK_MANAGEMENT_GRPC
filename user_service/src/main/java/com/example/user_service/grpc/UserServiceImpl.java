package com.example.user_service.grpc;

import com.example.bank.proto.user.User;
import com.example.bank.proto.user.UserRequest;
import com.example.bank.proto.user.UserResponse;
import com.example.bank.proto.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void createUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        // Logic for creating a user
        String name = request.getName();
        String email = request.getEmail();
        String password = request.getPassword();
        String address = request.getAddress();
        String phoneNumber = request.getPhoneNumber();

        // Create a UserResponse object to simulate a response
        UserResponse response = UserResponse.newBuilder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(UserRequest request, StreamObserver<User> responseObserver) {
        // Logic for getting a user by name (mock response)
        String name = request.getName();

        // Creating a mock user object for demonstration
        User user = User.newBuilder()
                .setId("123")  // Simulating an existing user ID
                .setName(name)
                .setEmail("example@example.com")
                .setPassword("password123")
                .setAddress("1234 Street, City")
                .setPhoneNumber("9876543210")
                .build();

        // Send the user response
        responseObserver.onNext(user);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        // Logic for updating user information (mock response)
        String name = request.getName();
        String email = request.getEmail();
        String password = request.getPassword();
        String address = request.getAddress();
        String phoneNumber = request.getPhoneNumber();

        // Create a mock response object to simulate update
        UserResponse response = UserResponse.newBuilder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        // Logic for deleting a user (mock response)
        String name = request.getName();

        // Simulate a deletion response
        UserResponse response = UserResponse.newBuilder()
                .setName(name)
                .setEmail("deleted@example.com")
                .setPassword("password")
                .setAddress("deleted address")
                .setPhoneNumber("0000000000")
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
