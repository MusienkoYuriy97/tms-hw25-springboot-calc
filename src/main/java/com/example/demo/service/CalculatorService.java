package com.example.demo.service;

import com.example.demo.dao.OperationDao;
import com.example.demo.model.Operation;
import com.example.demo.model.calc.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalculatorService {
    @Autowired
    OperationDao operationDao;
    @Autowired
    Map<Integer, Action> calcAction;

    public double calculate(int type, double x, double y){
        return calcAction.get(type).calculate(x, y);
    }
}
