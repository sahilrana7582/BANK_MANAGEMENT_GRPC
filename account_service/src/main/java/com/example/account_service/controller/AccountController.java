package com.example.account_service.controller;



import com.example.account_service.Grpc.UserGrpcClient;
import com.example.bank.proto.user.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final Logger LOG = LoggerFactory.getLogger(AccountController.class);


    private final UserGrpcClient userGrpcClient;

    public AccountController(UserGrpcClient userGrpcClient) {
        this.userGrpcClient = userGrpcClient;
    }




    @GetMapping("/get-user/{name}")
    public ResponseEntity<String> getUser(@PathVariable String name) {
        User user = userGrpcClient.getUser(name);
        LOG.info("Got User {}", user);
        return ResponseEntity.ok("Got user: " + user.getEmail());
    }
}


