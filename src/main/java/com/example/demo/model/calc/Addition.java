package com.example.demo.model.calc;

import org.springframework.stereotype.Component;

@Component
public class Addition implements Action {

    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}
