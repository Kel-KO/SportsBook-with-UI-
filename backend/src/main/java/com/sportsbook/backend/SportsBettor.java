package com.sportsbook.backend;
import jakarta.persistence.*;

@Entity
public class SportsBettor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float balance;

    // Constructors
    public SportsBettor() {} // Required by JPA

    public SportsBettor(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}