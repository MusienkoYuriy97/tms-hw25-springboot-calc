package com.example.demo.controller;

import com.example.demo.model.CalcDTO;
import com.example.demo.model.Operation;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.service.CalculatorService;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<Operation> calc(@RequestBody CalcDTO calcDTO, @RequestHeader("U-Token")String tokenId){
        Operation operation = new Operation();

        operation.setOperationType(calcDTO.getOperationType());

        User user = userService.getByTokenId(tokenId);
        System.out.println(user);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            operation.setUsername(user.getUsername());

            operation.setX(calcDTO.getX());
            operation.setY(calcDTO.getY());
            operation.setResult(calculatorService.calculate(calcDTO.getOperationType(),calcDTO.getX(),calcDTO.getY()));
            return new ResponseEntity<>(operation, HttpStatus.ACCEPTED);
        }
    }
}
