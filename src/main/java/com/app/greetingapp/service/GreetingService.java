package com.app.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    //UC2
    public String getGreetingMessage() {
        return "Hello, World!, Here is Service UC2";
    }
}