package com.example.demo.service;

import com.example.demo.dao.TokenDao;
import com.example.demo.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenService {
    @Autowired
    private TokenDao tokenDao;

    public Token get(String tokenId){
        Optional<Token> token = tokenDao.get(tokenId);
        return token.orElse(null);
    }
}
