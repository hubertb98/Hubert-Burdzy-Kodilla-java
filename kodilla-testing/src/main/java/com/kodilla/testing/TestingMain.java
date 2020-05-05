package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(5,16);
        int resultSubstract = calculator.substract(17,9);

        if (resultAdd == 21) {
            System.out.println("test Ok!");
        } else {
            System.out.println("Error!");
        }

        if (resultSubstract == 8) {
            System.out.println("test Ok!");
        } else {
            System.out.println("Error!");
        }
    }
}
