package com.app.greetingapp.repository;

import com.app.greetingapp.model.GreetingModel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GreetingRepository {
    private final Map<Long, GreetingModel> greetingMap = new HashMap<>();
    private long idCounter = 1;

    public GreetingModel save(GreetingModel greeting) {
        greeting.setId(idCounter++);
        greetingMap.put(greeting.getId(), greeting);
        return greeting;
    }
}
