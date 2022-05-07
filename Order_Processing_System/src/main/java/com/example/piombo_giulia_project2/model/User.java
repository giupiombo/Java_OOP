package com.example.piombo_giulia_project2.model;

public class User {
    private final String id;
    private final String password;
    private final String name;
    private final String address;
    private String creditCardNumber;
    private final String securityQuestion;
    private final String questionAnswer;

    public User (String id, String password, String name, String address, String cardNumber, String securityQuestion,
                 String questionAnswer) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.creditCardNumber = cardNumber;
        this.securityQuestion = securityQuestion;
        this.questionAnswer = questionAnswer;
    }

    public User (String id, String password, String name, String address, String securityQuestion,
                 String questionAnswer) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.securityQuestion = securityQuestion;
        this.questionAnswer = questionAnswer;
    }

    // getting the user's id
    public String getId() {
        return id;
    }

    // getting the user's password
    public String getPassword() {
        return password;
    }

    // getting the user's security question's answer
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    // getting the user's credit card number
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    // getting the user's security question
    public String getSecurityQuestion() {
        return securityQuestion;
    }
}
