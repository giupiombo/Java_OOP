package com.example.piombo_giulia_project2.controller;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.User;
import java.util.Objects;

public class UserController {

    // create a new customer user
    public User create (String username, String password, String name, String address, String creditCardNumber,
                        String selectedQuestion, String answer) {

        // variables to verify id and password
        boolean verifyID = false;
        boolean verifyPassword = false;

        // verify id
        while (!verifyID) {

            for (User user : Database.getInstance().getUsersCustomer()) {

                if (user != null) {

                    // validating that the id does not exist
                    if (Objects.equals(username, user.getId())) {
                        System.out.println("The id already exist!");
                        return null;
                    }

                    else {
                        verifyID = true;
                    }
                }
            }
        }

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
               return null;
            }
        }

        // if name is null, insert again
        if (name == null) {
            System.out.println("The name must not be null!");
            return null;
        }

        // if address is null, insert again
        if (address == null) {
            System.out.println("The address must not be null!");
            return null;
        }

        // if card number is null, insert again
        if (creditCardNumber == null) {
            System.out.println("The card number must not be null!");
            return null;
        }

        // creating a new user
        User newUser = new User(username, password, name, address, creditCardNumber, selectedQuestion, answer);

        return newUser;
    }

    // create a new business user
    public User create (String username, String password, String name, String address, String selectedQuestion,
                        String answer) {

        // variables to verify id and password
        boolean verifyID = false;
        boolean verifyPassword = false;

        // verify id
        while (!verifyID) {

            for (User user : Database.getInstance().getUsersBusiness()) {

                if (user != null) {

                    // validating that the id does not exist
                    if (Objects.equals(username, user.getId())) {
                        System.out.println("The id already exist!");
                        return null;
                    }

                    else {
                        verifyID = true;
                    }
                }
            }
        }

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
                return null;
            }
        }

        // if name is null, insert again
        if (name == null) {
            System.out.println("The name must not be null!");
            return null;
        }

        // if address is null, insert again
        if (address == null) {
            System.out.println("The address must not be null!");
            return null;
        }

        // creating a new user
        User newUser = new User(username, password, name, address, selectedQuestion, answer);

        return newUser;
    }

    // log on
    public User logOn (String username, String password) {

        User foundUser = null;

        // verifying if user exists
        if (Database.getInstance().getSelectTypeOfUser().equals("customer")) {
            for (User curUser : Database.getInstance().getUsersCustomer()) {
                if (curUser != null) {
                    if (Objects.equals(username, curUser.getId())) {
                        foundUser = curUser;
                    }
                }
            }
        } else if (Database.getInstance().getSelectTypeOfUser().equals("business")) {
            for (User curUser : Database.getInstance().getUsersBusiness()) {
                if (curUser != null) {
                    if (Objects.equals(username, curUser.getId())) {
                        foundUser = curUser;
                    }
                }
            }
        }

        if (foundUser == null) {
            System.out.println("Wrong answer!");
            return null;
        }

        // 3 attempts
        for (int attempt = 0; attempt < 3; attempt++) {
            // validating password
            if (Objects.equals(password, foundUser.getPassword())) {
                return foundUser;
            }
        }
        return null;
    }

    // saving a new user
    public void save (User user) {
        Database.getInstance().insertUser(user);
    }

    // verify the security question answer
    public boolean verifySecurityAnswer (String inputAnswer) {
        if (Objects.equals(inputAnswer, Database.getInstance().getLoggedUser().getQuestionAnswer())) {
            return true;
        } else {
            return false;
        }
    }
}
