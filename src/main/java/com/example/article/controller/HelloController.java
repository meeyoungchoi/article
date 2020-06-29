package com.example.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "helloworld";
    }

    @GetMapping("/greetings")
    public String greet() {
        return "greetings";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

}

