package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception {

    public static String ERR_EMPLOYEE_NOT_FOUND = "Employee is not found";
    public static String ERR_COMPANY_NOT_FOUND = "Company is not found";
    public static String ERR_NOT_THREE_LETTERS = "It is not three letters";
    public static String ERR_NOT_ENOUGH_LETTERS = "it is not enough letters";

    public SearchingException(String message) {
        super(message);
    }
}
