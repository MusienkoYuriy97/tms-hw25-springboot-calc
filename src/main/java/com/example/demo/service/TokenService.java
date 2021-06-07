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


    public boolean delete(String tokenId){
        if (tokenDao.isExist(tokenId)) {
            tokenDao.delete(tokenDao.get(tokenId).get());
            return true;
        }
        return false;
    }

    public void save(int userId, String tokenId){
        tokenDao.save(new Token(tokenId,userId));
    }

    public boolean isExist(String tokenId){
        return tokenDao.isExist(tokenId);
    }
}
