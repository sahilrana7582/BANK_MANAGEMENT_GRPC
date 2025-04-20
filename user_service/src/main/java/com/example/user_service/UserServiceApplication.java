package com.example.user_service;

import com.example.user_service.grpc.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	@Value("${grpc.server.port:50051}")
	private int grpcServerPort; // Default port is 50051 if not specified

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create the gRPC server
		Server server = ServerBuilder.forPort(grpcServerPort)
				.addService(new UserServiceImpl()) // Register the gRPC service implementation
				.build();

		// Start the server
		System.out.println("Starting UserService gRPC server on port " + grpcServerPort);
		server.start();
		server.awaitTermination(); // Keep the server running
	}
}
