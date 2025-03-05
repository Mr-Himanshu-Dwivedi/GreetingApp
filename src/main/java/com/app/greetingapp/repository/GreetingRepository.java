package com.app.greetingapp.repository;

import com.app.greetingapp.model.GreetingModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
//
//@Repository
//public class GreetingRepository {
//    private final Map<Long, GreetingModel> greetingMap = new HashMap<>();
//    private long idCounter = 1;
//
//    public GreetingModel save(GreetingModel greeting) {
//        greeting.setId(idCounter++);
//        greetingMap.put(greeting.getId(), greeting);
//        return greeting;
//    }
//
//    // UC 5 - Find greeting by ID
//    public GreetingModel findById(Long id) {
//        return greetingMap.get(id);
//    }
//
//    // UC 6 - List all greetings
//    public List<GreetingModel> findAll() {
//        return new ArrayList<>(greetingMap.values());
//    }
//}

//UC7 with H2 Database
@Repository
public interface GreetingRepository extends JpaRepository<GreetingModel, Long> {
}
