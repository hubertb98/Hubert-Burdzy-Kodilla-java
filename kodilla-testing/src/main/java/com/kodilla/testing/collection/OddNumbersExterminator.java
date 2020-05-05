package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        System.out.print("Odd numbers: ");
        for (Integer number: numbers) {
            if ((number % 2) == 1) {
                System.out.print(number + ", ");
            }
        }
        return numbers;
    }
}
