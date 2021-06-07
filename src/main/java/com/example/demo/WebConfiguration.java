package com.example.demo;

import com.example.demo.model.calc.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ComponentScan(basePackages = "com.example")
public class WebConfiguration {
    @Bean
    public Map<Integer, Action> calcAction(Action add, Action sub, Action div, Action mul){
        Map<Integer,Action> calcAction = new HashMap<>();
        calcAction.put(1,add);
        calcAction.put(2,sub);
        calcAction.put(3,div);
        calcAction.put(4,mul);
        return calcAction;
    }

    @Bean
    public Action add(){
        return new Addition();
    }

    @Bean
    public Action mul(){
        return new Multiply();
    }

    @Bean
    public Action sub(){
        return new Subtract();
    }

    @Bean
    public Action div(){
        return new Divide();
    }

}
