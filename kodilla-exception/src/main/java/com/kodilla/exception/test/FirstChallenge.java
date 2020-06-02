package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0;
        try {
            result = firstChallenge.divide(3,0);

        } catch (ArithmeticException ae) {
            System.out.println("Number divided by zero is always zero. " +
                    "Please enter another number.");
        } finally {
            System.out.println("Result: " + result);
        }
    }
}
