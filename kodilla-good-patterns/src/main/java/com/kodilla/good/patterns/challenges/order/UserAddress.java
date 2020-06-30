package com.kodilla.good.patterns.challenges.order;

public class UserAddress {
    private String city;
    private int postCode;
    private String street;
    private int houseNumber;

    public UserAddress(String city, int postCode, String street, int houseNumber) {
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return city + ", " + street + " " + houseNumber + ", post code " + postCode;
    }
}
