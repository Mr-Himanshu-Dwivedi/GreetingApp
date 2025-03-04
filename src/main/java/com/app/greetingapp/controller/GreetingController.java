package com.app.greetingapp.controller;

import com.app.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

//    @GetMapping
//    public String getGreeting() {
//        return "Hello, World!";
//    }

    //UC2
    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }
}
