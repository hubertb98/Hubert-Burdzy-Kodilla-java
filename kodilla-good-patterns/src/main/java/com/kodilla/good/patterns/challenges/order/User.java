package com.kodilla.good.patterns.challenges.order;

public class User {
    private String name;
    private String surname;
    private String mail;
    private UserAddress userAddress;

    public User(String name, String surname, String mail, UserAddress userAddress) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.userAddress = userAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }
}
