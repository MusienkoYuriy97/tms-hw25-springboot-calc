package com.example.demo.dao;


import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> get();
    void save(User user) ;
    boolean contains(String username);
    boolean contains(String username, String password);
    Optional<User> getByUsername(String username);
    Optional<User> getByUsernameAndPassword(String username,String password);
    Optional<User> getById(int id);
}

