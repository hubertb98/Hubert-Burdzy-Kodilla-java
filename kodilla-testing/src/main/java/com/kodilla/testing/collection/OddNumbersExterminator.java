package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> oddNumbersList = new ArrayList<>();

        for (Integer number: numbers) {
            if ((number % 2) == 1) {
                oddNumbersList.add(number);
//                System.out.print(number + ", ");
            }
        }
        return oddNumbersList;
    }
}
