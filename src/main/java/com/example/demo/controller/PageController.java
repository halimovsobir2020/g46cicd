package com.example.demo.controller;

import com.example.demo.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final StudentRepository studentRepository;

    public PageController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "home";
    }

}
