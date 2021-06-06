package com.example.demo.service;

import com.example.demo.dao.TokenDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    TokenDao tokenDao;

    public boolean save(User user){
        if (userDao.contains(user.getUsername())){
            return false;
        }
        userDao.save(user);
        return true;
    }

    public User getUserByUsername(String username){
        return userDao.getUserByUsername(username).orElse(null);
    }

    public User getUserById(int id){
        return userDao.getUserById(id).orElse(null);
    }

    public User getByToken(Token token){
        if (tokenDao.contains(token)) {
            return userDao.getUserById(token.getUserId()).get();
        }else {
            return null;
        }
    }
}
