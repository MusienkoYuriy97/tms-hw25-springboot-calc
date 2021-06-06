package com.example.demo.dao;


import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDao implements UserDao {
    private static List<User> users = new ArrayList<>();
    private static int id = 1;

    public List<User> get() {
        return users;
    }

    public void save(User user) {
        user.setId(id++);
        users.add(user);
    }


    public boolean contains(String username){
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public boolean contains(String username, String password){
        return users.stream().anyMatch(user -> user.getUsername().equals(username)
                && user.getPassword().equals(password));
    }

    @Override
    public Optional<User> getUserByUsername(String username)  {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().map(Optional::of).orElse(null);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().map(Optional::of).orElse(null);
    }
}
