package model;

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

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}