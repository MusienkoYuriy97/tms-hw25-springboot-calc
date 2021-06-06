package com.example.demo.dao;

import com.example.demo.model.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class InMemoryOperationDao implements OperationDao {
    private static List<Operation> operations = new ArrayList<>();

    public void add(Operation operation){
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public void removeAll() {
        operations.removeAll(operations);
    }
}
