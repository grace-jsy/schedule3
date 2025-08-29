package org.example.schedule3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Schedule3Application {

    public static void main(String[] args) {
        SpringApplication.run(Schedule3Application.class, args);
    }

}
