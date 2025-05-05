package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Lazy
public class ScopeBean {

    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @PostConstruct
    public void init() {
        System.out.println("Scope бин создан!");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Scope бин уничтожен!");
    }
}
