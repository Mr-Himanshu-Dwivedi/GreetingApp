package com.app.greetingapp.service;

import org.springframework.stereotype.Service;
import com.app.greetingapp.model.GreetingModel;

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
}