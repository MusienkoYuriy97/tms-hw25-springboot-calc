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
        return tokens.stream().filter(token -> token.getTokenId().equals(tokenId)).findFirst().map(Optional::of).orElse(null);
    }

    @Override
    public boolean delete(Token token) {
        return tokens.remove(token);
    }

    @Override
    public boolean contains(Token token) {
        return tokens.contains(token);
    }
}
