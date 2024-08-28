package com.xcoder.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    Mono<Student> save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    Flux<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(@PathVariable Integer id) {
        return studentService.findById(id);
    }
}
