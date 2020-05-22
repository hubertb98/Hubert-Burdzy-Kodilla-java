package com.kodilla.rps;

import java.util.Scanner;

public class InputOutput {
    private static Scanner scan = new Scanner(System.in);

    public String getStringInput() {
        String input = scan.nextLine();
        if (!(input.equals("n") || input.equals("x")))
            System.out.println("zła");
        return input;
    }

    public int getIntInput() {
        String input = scan.nextLine();
        boolean isCorrectValues = false;

        while (!isCorrectValues) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Wpisano złą wartość, proszę spróbować jeszcze raz.");
                input = scan.nextLine();
            }
        }
        return 0;
    }
}
