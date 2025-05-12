package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationSender {

    //Используется паттерн "Стратегия" — Map<String, NotificationService> как контейнер стратегий.
    private final Map<String, NotificationService> strategies;

    //Внедрение зависимостей происходит через конструктор с @Qualifier — это DI
    // Spring автоматически внедрит все реализации интерфейса NotificationService
    public NotificationSender(Map<String, NotificationService> strategies) {
        this.strategies = strategies;
    }

    //Теперь ты можешь добавить хоть 10 новых способов (WhatsApp, Push, VK) — без изменения NotificationSender. Нужно просто создать новый @Component("...").
    public void sendNotification(String type, String message) {
        NotificationService strategy = strategies.get(type.toLowerCase());
        if (strategy != null) {
            strategy.send(message);
        } else {
            System.out.println("Неизвестный тип уведомления: " + type);
        }
    }
}

