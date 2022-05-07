package com.example.piombo_giulia_project2.model;

import java.util.*;

public class Bank {

    private final List<Account> accounts;

    public Bank () {
        this.accounts = new ArrayList<>();
        Account account = new Account("2839-3748-2748-7394");
        accounts.add(account);
    }

    // validating credit card
    public int validateCreditCard (String creditCardNumber, double totalPrice) {

        // trying to find an account match
        for (Account account : accounts) {
            if (Objects.equals(account.getCreditCardNumber(), creditCardNumber) && totalPrice <= account.getBalance()) {

                // creating a random variable to display the 4 digit security number
                Random rand = new Random();
                int authorization = rand.nextInt(10000);

                System.out.println("Security number: ");
                System.out.printf("%04d%n", authorization);
                return authorization;
            }
        }
        return -1;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
