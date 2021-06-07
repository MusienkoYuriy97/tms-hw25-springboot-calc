package com.example.demo.controller;


import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> auth(String username, String password){
        if (userService.checkAuthorization(username,password)){
            int userId = userService.getByUsername(username).getId();
            String tokenId = UUID.randomUUID().toString();
            tokenService.save(userService.getByUsername(username).getId(),
                    tokenId);
            return new ResponseEntity<>(tokenId, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
}
