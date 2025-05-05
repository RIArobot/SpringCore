package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringCore {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoSpringCore.class, args);
        SimpleTimer timer = ctx.getBean(SimpleTimer.class);
        timer.start();

        ScopeBean sb = ctx.getBean(ScopeBean.class);
        sb.setData("1");
        System.out.println(sb.getData());



        GreetingService greetingService = ctx.getBean(GreetingService.class);
        AppProperties appProp = ctx.getBean(AppProperties.class);

        greetingService.greet("Spring Core with Gradle");
        System.out.println("App name = " + appProp.getName() + "; app version = " + appProp.getVersion());

        timer.stop();
        System.out.println(ctx.getBean(ScopeBean.class).getData());
    }

}
