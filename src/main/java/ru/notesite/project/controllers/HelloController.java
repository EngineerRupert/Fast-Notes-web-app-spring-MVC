package ru.notesite.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/index")
    public String sayHello() {
        return "/hello_world";
    }

}
