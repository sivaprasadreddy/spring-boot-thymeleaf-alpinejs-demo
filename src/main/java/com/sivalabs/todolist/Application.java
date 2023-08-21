package com.sivalabs.todolist;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(TodoRepository repo) {
        return (args) -> {
            repo.save(new Todo(null, "Learn HTMX"));
            repo.save(new Todo(null, "Learn AlpineJS"));
            repo.save(new Todo(null, "Learn SpringBoot"));
        };
    }
}
