package com.example.piombo_giulia_project2.model;

import java.util.Random;

public class Account {

    private final String creditCardNumber;
    private final double balance;

    public Account (String creditCardNumber) {
        Random rand = new Random();

        this.creditCardNumber = creditCardNumber;

        // creating a random value between 1,000 and 10,000 for the balance in the account
        this.balance = 1000 + (10000 - 1000) * rand.nextDouble();
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public double getBalance() {
        return balance;
    }
}
