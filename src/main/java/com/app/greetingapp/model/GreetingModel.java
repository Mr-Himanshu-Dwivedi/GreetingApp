package com.app.greetingapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class GreetingModel {
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public GreetingModel() {}

    //UC3
//    public GreetingModel(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    //!--UC4 Starts here
    public GreetingModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //!--UC4 Ends here

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMessage() {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello, World!";
        }
    }
}
