package ca.dhruvanshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTemplateDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateDemoApplication.class, args);
        System.out.println("Application started successfully!");
        System.out.println("Access your endpoints at: http://localhost:8080/api/");
        System.out.println("Health check: http://localhost:8080/actuator/health");
    }
}