package com.upa.academicapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/newStudent")
    public String create() {
        return "newStudent";
    }

    @RequestMapping("/student")
    public String student() {
        return "student";
    }

    @RequestMapping("/students")
    public String students() {
        return "students";
    }
}
