package controller;

import model.Account;
import model.Bank;

import java.util.List;
import java.util.Objects;

public class BankController {

    private final Bank bank;

    public BankController (Bank bank) {
        this.bank = bank;
    }

    // verifying the card
    public int verifyCreditCard (String creditCardNumber, double totalPrice) {
        return this.bank.validateCreditCard(creditCardNumber, totalPrice);
    }

    // create a new account
    public void createAccount (String creditCardNumber) {
        Account account = new Account(creditCardNumber);
        this.bank.getAccounts().add(account);
    }

    // get account
    public Account getAccount (String creditCardNumber) {
        List<Account> accounts = this.bank.getAccounts();
        for (Account account : accounts) {
            if (Objects.equals(account.getCreditCardNumber(), creditCardNumber)) {
                return account;
            }
        }
        return null;
    }
}
