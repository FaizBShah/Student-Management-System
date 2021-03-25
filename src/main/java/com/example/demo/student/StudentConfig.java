package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student faiz = new Student(
                    "Faiz",
                    "faizbshah2001@gmail.com",
                    LocalDate.of(2001, MARCH, 24)
            );

            Student mariam = new Student(
                    "mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            studentRepository.saveAll(List.of(faiz, mariam));
        };
    }
}
