package com.company.core;

import java.util.Scanner;

public class MethodReturnTypesDemoSingleMethod {
    public static void main(String[] args) {
        String name = "";
        boolean isValid = true;
        do {
            System.out.print("Please, enter your name (use only letters): ");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            isValid = true;

            if (name == null || name.isEmpty()) {
                // code after 'return' is not executed
                isValid = false;
            } else {
                for (char ch : name.toCharArray()) {
                    if (!Character.isAlphabetic(ch)) {
                        // another 'early exit' - if we reach a character that is not a letter,
                        // there is no point to check the others
                        isValid = false;
                    }
                }
            }
        } while (!isValid);

        System.out.printf("Hello, %s!%n", name);
        System.out.println("Good luck!");
    }
}
