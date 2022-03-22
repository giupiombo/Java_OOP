package controller;

import model.Database;
import model.User;

import java.util.Objects;
import java.util.Scanner;

public class UserController {

    static Scanner sc = new Scanner(System.in);

    private final Database db;

    public UserController (Database db) {
        this.db = db;
    }

    // create a new user
    public User create () {

        // array with the security questions
        String[] questions = new String[3];
        questions[0] = "1. What is the name of your pet?";
        questions[1] = "2. What is your hometown?";
        questions[2] = "3. What was your first school?";

        // variables to verify id and password
        boolean verifyID = false;
        boolean verifyPassword = false;

        // getting the id
        System.out.print("ID: ");
        String id = sc.next();

        // verify id
        while (!verifyID) {

            for (User user : db.getUsers()) {

                if (user != null) {

                    // validating that the id does not exist
                    if (Objects.equals(id, user.getId())) {
                        System.out.println("The id already exist!");

                        // if it already exists, input a new one
                        System.out.print("ID: ");
                        id = sc.next();
                    }

                    else {
                        verifyID = true;
                    }
                }
            }
        }

        // getting the password
        System.out.print("Password : ");
        String password = sc.next();

        // verify password
        while (!verifyPassword) {

            // variables to check if the password matches the requirements
            boolean digit = false;
            boolean specialCharacter = false;
            boolean upperCase = false;

            // validating that the password contains 6 characters
            if (password.length() >= 6) {
                char ch;

                // verify if it contains number, special character and upper case letter
                for (int i = 0; i < password.length(); i++) {

                    ch = password.charAt(i);

                    if (Character.isDigit(ch)) {
                        digit = true;
                    } else if (Character.isUpperCase(ch)) {
                        upperCase = true;
                    } else if (ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '&' || ch == '*') {
                        specialCharacter = true;
                    }
                }
            }

            // if all the cases passes, the password is created
            if (digit && upperCase && specialCharacter) {
                verifyPassword = true;
            }

            else {
                System.out.println("The password must contain at least 6 characters, 1 number, 1 special character and 1 upper case letter!");
                System.out.print("Password : ");
                password = sc.next();
            }
        }

        // getting the name
        System.out.print("Name: ");
        String name = sc.next();

        // getting the address
        System.out.print("Address: ");
        String address = sc.next();

        // getting the credit card number
        System.out.print("Credit Card Number: ");
        String cardNumber = sc.next();

        // if name is null, insert again
        if (name == null) {
            System.out.println("The name must not be null!");
            System.out.print("Name: ");
            name = sc.next();
        }

        // if address is null, insert again
        if (address == null) {
            System.out.println("The address must not be null!");
            System.out.print("Address: ");
            address = sc.next();
        }

        // if card number is null, insert again
        if (cardNumber == null) {
            System.out.println("The card number must not be null!");
            System.out.print("Credit Card Number: ");
            cardNumber = sc.next();
        }

        // choosing the security question
        System.out.println("Select your security question: ");
        for (String question : questions) {
            System.out.println(question);
        }
        int questionChoice = sc.nextInt();

        // getting the answer
        System.out.print("Answer: ");
        String questionAnswer = sc.next();

        // creating a new user
        User newUser = new User(id, password, name, address, cardNumber, questions[questionChoice-1], questionAnswer);

        System.out.println("model.Account created successfully!");

        return newUser;
    }

    // log on
    public User logOn () {

        User foundUser = null;

        // getting the id
        System.out.print("ID: ");
        String inputID = sc.next();

        // verifying if user exists
        for (User curUser : db.getUsers()) {
            if (curUser != null) {
                if (Objects.equals(inputID, curUser.getId())) {
                    foundUser = curUser;
                }
            }
        }

        if (foundUser == null) {
            System.out.println("Wrong answer!");
            return null;
        }

        // 3 attempts
        for (int attempt = 0; attempt < 3; attempt++) {

            // getting the password
            System.out.print("Password: ");
            String inputPassword = sc.next();

            // validating password
            if (Objects.equals(inputPassword, foundUser.getPassword())) {

                // print security question
                System.out.println(foundUser.getSecurityQuestion());
                String inputAnswer = sc.next();

                // validating answer
                if (Objects.equals(inputAnswer, foundUser.getQuestionAnswer())) {
                    System.out.println("\n--- WELCOME ---");
                    return foundUser;
                }

                // terminates the program
                else {
                    System.out.println("Wrong answer!");
                    return null;
                }
            }
        }
        return null;
    }

    // saving a new user
    public void save (User user) {
        this.db.insertUser(user);
    }
}