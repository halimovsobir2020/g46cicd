package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    private final StudentRepository studentRepository;

    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        if (ddl.equals("create")) {
            for (int i = 0; i < 10; i++) {
                Student student = new Student(
                        "student" + i,
                        "studetnov" + i
                );
                studentRepository.save(student);
            }
        }
    }
}
