package com.xcoder.reactive;

import com.xcoder.reactive.student.Student;
import com.xcoder.reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            for (int i = 0; i < 3000; i++) {
                studentService.save(getStudent(i)).subscribe();
            }
        };
    }

    private Student getStudent(int i) {
        return Student.builder()
            .firstname("Test" + i)
            .lastname("test" + i)
            .age(i)
            .build();
    }
}
