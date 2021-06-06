package com.example.demo.dao;

import com.example.demo.model.Operation;

import java.util.List;

public interface OperationDao {
    void add(Operation operation);
    List<Operation> getOperations();
    void removeAll();
}
