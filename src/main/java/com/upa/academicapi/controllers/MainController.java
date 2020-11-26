package com.upa.academicapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * I set the paths for the static files, for the visit of the HTML documents
 */
@Controller
public class MainController {

    /**
     * 
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 
     */
    @RequestMapping("/newStudent")
    public String create() {
        return "newStudent";
    }

    /**
     * 
     */
    @RequestMapping("/student")
    public String student() {
        return "student";
    }

    /**
     * 
     * @return
     */
    @RequestMapping("/students")
    public String students() {
        return "students";
    }
}
