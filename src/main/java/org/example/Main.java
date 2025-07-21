package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // Birkaç kullanıcı kaydet
            User user1 = new User();
            user1.setName("John Doe");
            user1.setEmail("john.doe@example.com");
            repository.save(user1);

            User user2 = new User();
            user2.setName("Jane Doe");
            user2.setEmail("jane.doe@example.com");
            repository.save(user2);

            // Tüm kullanıcıları getir ve yazdır
            System.out.println("Users found with findAll():");
            System.out.println("-------------------------------");
            for (User user : repository.findAll()) {
                System.out.println(user.getName() + " " + user.getEmail());
            }
            System.out.println();
        };
    }
}