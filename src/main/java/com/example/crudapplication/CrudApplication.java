package com.example.crudapplication;

import com.example.crudapplication.entities.User;
import com.example.crudapplication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudApplication.class, args);

        System.out.println("CRUD APPLICATION !!");
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository){
        return args -> {
            User user1 = User.builder()
                    .nom("HADDOUCH")
                    .prenom("EL Mahdi")
                    .password("1234")
                    .role("User")
                    .build();
            User user2 = User.builder()
                    .nom("SADEQ")
                    .prenom("Ali")
                    .role("Admin")
                    .password("1234")
                    .build();
            User user3 = User.builder()
                    .nom("AAA")
                    .prenom("Mohammed")
                    .role("User")
                    .password("1234")
                    .build();
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };

    }

}
