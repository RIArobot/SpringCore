package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }


}
