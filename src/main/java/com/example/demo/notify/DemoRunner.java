package com.example.demo;

import com.example.demo.notify.NotificationSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DemoRunner implements CommandLineRunner {

    private final NotificationSender sender;

    public DemoRunner(NotificationSender sender) {
        this.sender = sender;
    }

    //Пользователь вводит "email" или "sms".
    //Затем вводит текст сообщения.
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип уведомления (email или sms): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.println("Введите сообщение для отправки: ");
        String message = scanner.nextLine();

        try {
            sender.sendNotification(type, message);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
