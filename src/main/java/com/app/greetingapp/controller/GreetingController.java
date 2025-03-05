package com.app.greetingapp.controller;

import com.app.greetingapp.model.GreetingModel;
import com.app.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    // UC 7 - Create a new greeting
    @PreAuthorize("isAuthenticated()")  // ✅ Requires JWT token
    @PostMapping
    public GreetingModel createGreeting(@RequestParam String firstName, @RequestParam String lastName) {
        return greetingService.createGreeting(firstName, lastName);
    }

    // UC 5 - Get greeting by ID
    @PreAuthorize("isAuthenticated()")  // ✅ Requires JWT token
    @GetMapping("/{id}")
    public GreetingModel getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC 6 - List all greetings
    @PreAuthorize("isAuthenticated()")  // ✅ Requires JWT token
    @GetMapping("/all")
    public List<GreetingModel> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC 7 - Update a greeting
    @PreAuthorize("isAuthenticated()")  // ✅ Requires JWT token
    @PutMapping("/{id}")
    public GreetingModel updateGreeting(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName) {
        return greetingService.updateGreeting(id, firstName, lastName);
    }

    // UC 8 - Delete a greeting
    @PreAuthorize("isAuthenticated()")  // ✅ Requires JWT token
    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}
