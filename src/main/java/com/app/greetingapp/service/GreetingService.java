package com.app.greetingapp.service;

import org.springframework.stereotype.Service;
import com.app.greetingapp.model.GreetingModel;
import com.app.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class GreetingService {
    //UC2
//    public String getGreetingMessage() {
//        return "Hello, World!, Here is Service UC2";
//    }

    //UC3
    public String getGreetingMessage(String firstName, String lastName) {
        GreetingModel greeting = new GreetingModel(firstName, lastName);
        return greeting.getMessage();
    }



    //UC4
    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingModel createGreeting(String firstName, String lastName) {
        GreetingModel greeting = new GreetingModel(firstName, lastName);
        return greetingRepository.save(greeting);
    }

    // UC 5 - Retrieve greeting by ID
    public GreetingModel getGreetingById(Long id) { // UC 5 - Retrieve greeting by ID
        return greetingRepository.findById(id).orElse(null);
    }

    // UC 6 - Retrieve all greetings
    public List<GreetingModel> getAllGreetings() {
        return greetingRepository.findAll();
    }

    //UC7 - Editing greeting by ID
    public GreetingModel updateGreeting(Long id, String firstName, String lastName) {
        Optional<GreetingModel> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            GreetingModel greeting = existingGreeting.get();
            greeting.setFirstName(firstName);
            greeting.setLastName(lastName);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    //UC8 - Deleting greeting by ID
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}