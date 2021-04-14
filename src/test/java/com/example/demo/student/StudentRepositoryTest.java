package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.Month.MARCH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();;
    }

    @Test
    void checkStudentEmailExists() {
        // given
        String email = "faizbshah2001@gmail.com";
        Student student = new Student(
                "Faiz",
                email,
                LocalDate.of(2001, MARCH, 24)
        );
        underTest.save(student);

        // when
        Optional<Student> expected = underTest.findStudentByEmail(email);

        // then
        assertThat(expected.isPresent()).isTrue();
    }

    @Test
    void checkStudentEmailNotExists() {
        // given
        String email = "faizbshah2001@gmail.com";

        // when
        Optional<Student> expected = underTest.findStudentByEmail(email);

        // then
        assertThat(expected.isPresent()).isFalse();
    }
}