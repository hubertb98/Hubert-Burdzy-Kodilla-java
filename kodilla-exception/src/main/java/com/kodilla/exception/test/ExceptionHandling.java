package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "No result";

        try {
            result = secondChallenge.probablyWillThrowException(2, 1);
        } catch (Exception e) {
            System.out.println("Exception:\n" + e);
        } finally {
            System.out.println(result);
        }
    }
}
