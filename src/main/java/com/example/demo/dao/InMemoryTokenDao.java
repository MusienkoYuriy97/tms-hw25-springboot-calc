package com.example.demo.dao;

import com.example.demo.model.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryTokenDao implements TokenDao {
    private List<Token> tokens = new ArrayList<>();
    @Override
    public void save(Token token) {
        tokens.add(token);
    }

    @Override
    public Optional<Token> get(String tokenId) {
        for (Token token : tokens) {
            if (token.getTokenId().equals(tokenId)){
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Token token) {
        return tokens.remove(token);
    }

    @Override
    public boolean isExist(int userId) {
        return tokens.stream().anyMatch(token -> token.getUserId() == userId);
    }
    @Override
    public boolean isExist(String tokenId) {
        return tokens.stream().anyMatch(token -> token.getTokenId().equals(tokenId));
    }
}
