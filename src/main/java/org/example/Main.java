package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication/*Bu anotasyon, üç şeyi birden içerir:

@Configuration → Yapılandırma sınıfı olduğunu söyler.

@EnableAutoConfiguration → Spring Boot’un otomatik ayarlarını etkinleştirir.

@ComponentScan → Projedeki bileşenleri (@Component, @Service, @Repository, @RestController) otomatik bulur.

📌 Kısacası: Bu sınıf, Spring Boot uygulamasının başlangıç noktasıdır.

 */
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);/*SpringApplication.run(Main.class, args); uygulamayi baslatir. 
        Bütün @Component, @Service, @Repository sınıflarını tarar ve çalıştırır.*/
    }

        @Bean/*@Bean, Spring’e bu metotun bir Spring Bean’i olduğunu söyler.*/
        public CommandLineRunner demo(UserRepository repository) {
            /*CommandLineRunner, Spring Boot uygulaması başladığında otomatik olarak çalışan bir interface’dir.*/
        return (args) -> {
            // Birkaç kullanıcı kaydet
            User user1 = new User();//user1 kullaniciyi olusturur
            user1.setName("John Doe");
            user1.setEmail("john.doe@example.com");
            repository.save(user1);//save kullaniciyi kaydeder

            User user2 = new User();//user2 kullaniciyi olusturur
            user2.setName("Jane Doe");
            user2.setEmail("jane.doe@example.com");
            repository.save(user2);//save kullaniciyi kaydeder

            // Tüm kullanıcıları getir ve yazdır
            System.out.println("Users found with findAll():");//findAll kullaniciyi getirir
            System.out.println("-------------------------------");//------------------------------- kullaniciyi getirir
            for (User user : repository.findAll()) {//findAll kullaniciyi getirir
                System.out.println(user.getName() + " " + user.getEmail());//user.getName() kullaniciyi getirir
            }
            System.out.println();//kullaniciyi getirir
        };
    }
}