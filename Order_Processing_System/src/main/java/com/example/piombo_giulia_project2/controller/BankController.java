package com.example.piombo_giulia_project2.controller;

import com.example.piombo_giulia_project2.model.Account;
import com.example.piombo_giulia_project2.model.Bank;

import java.util.List;
import java.util.Objects;

public class BankController {

    private final Bank bank;
    CartController cartController = new CartController();

    public BankController (Bank bank) {
        this.bank = bank;
    }

    // verifying the card
    public int verifyCreditCard (String creditCardNumber, String delivery) {

        double totalPrice = 0;

        if (delivery.equals("mail")) {
            totalPrice = cartController.create()+3;
        } else {
            totalPrice = cartController.create();
        }
        return this.bank.validateCreditCard(creditCardNumber, totalPrice);
    }

    // create a new account
    public void createAccount (String creditCardNumber) {
        Account account = new Account(creditCardNumber);
        this.bank.getAccounts().add(account);
    }
}
