package com.example.demo.notify;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Отправка SMS: " + message);
    }
}
