package com.example.demo.service;

import com.example.demo.dao.TokenDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    TokenDao tokenDao;

    public boolean save(UserDTO userDTO){
        if (userDao.contains(userDTO.getUsername())){
            return false;
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFname(userDTO.getFname());
        user.setPassword(userDTO.getPassword());
        userDao.save(user);
        return true;
    }

    public User getByUsername(String username){
        return userDao.getByUsername(username).orElse(null);
    }

    public User getById(int id){
        return userDao.getById(id).orElse(null);
    }

    public User getByTokenId(String tokenId){
        Optional<Token> token = tokenDao.get(tokenId);
        if (token.isPresent()){
            return userDao.getById(token.get().getUserId()).get();
        }else {
            return null;
        }
    }

    public boolean checkAuthorization(String username, String password){
        Optional<User> optionalUser = userDao.getByUsernameAndPassword(username,password);
        return optionalUser.isPresent();
    }
}
