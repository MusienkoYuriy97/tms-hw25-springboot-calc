package com.example.demo.controller;

import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogOutController {
    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> auth(@RequestHeader("U-Token")String tokenId){
        if (tokenService.delete(tokenId)) {
            return new ResponseEntity<>("success logout", HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
