package com.app.greetingapp.controller;

import com.app.greetingapp.model.GreetingModel;
import com.app.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

//    @GetMapping
//    public String getGreeting() {
//        return "Hello, World!";
//    }

    //UC2
//    @Autowired
//    private GreetingService greetingService;
//
//    @GetMapping
//    public String getGreeting() {
//        return greetingService.getGreetingMessage();
//    }

    //UC3 and UC4
    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public GreetingModel getGreeting(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String lastName) {
        return greetingService.createGreeting(firstName, lastName);
    }

    // UC 5 - New endpoint to find a greeting by ID
    @GetMapping("/{id}") // UC 5 - New endpoint to find a greeting by ID
    public GreetingModel getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    //UC 6 - New endpoint to list all greetings
    @GetMapping("/all")
    public List<GreetingModel> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
