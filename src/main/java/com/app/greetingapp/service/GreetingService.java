package com.app.greetingapp.service;

import org.springframework.stereotype.Service;
import com.app.greetingapp.model.GreetingModel;
import com.app.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GreetingService {
    //UC2
//    public String getGreetingMessage() {
//        return "Hello, World!, Here is Service UC2";
//    }

    //UC3
//    public String getGreetingMessage(String firstName, String lastName) {
//        GreetingModel greeting = new GreetingModel(firstName, lastName);
//        return greeting.getMessage();
//    }

    //UC4
    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingModel createGreeting(String firstName, String lastName) {
        GreetingModel greeting = new GreetingModel(0L,firstName, lastName);
        greeting = greetingRepository.save(greeting); // Save greeting to repository (UC 4)
        return greeting;
    }

    // UC 5 - Retrieve greeting by ID
    public GreetingModel getGreetingById(Long id) { // UC 5 - Retrieve greeting by ID
        return greetingRepository.findById(id);
    }
}