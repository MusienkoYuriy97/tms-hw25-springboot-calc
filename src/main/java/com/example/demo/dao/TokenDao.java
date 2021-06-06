package com.example.demo.dao;

import com.example.demo.model.Token;

import java.util.Optional;

public interface TokenDao {
    void save(Token token);
    Optional<Token> get(String tokenId);
    boolean delete(Token token);
    boolean contains(Token token);
}
