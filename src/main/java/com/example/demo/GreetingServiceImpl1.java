package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingServiceImpl1 implements GreetingService {

    @Override
    public void greet(String name) {
        System.out.println("Hi, " + name + "!");
    }


}