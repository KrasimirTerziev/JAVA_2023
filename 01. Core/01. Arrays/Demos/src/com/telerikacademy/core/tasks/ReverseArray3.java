package com.telerikacademy.core.tasks;

import java.util.Scanner;

public class ReverseArray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[] reversed = new String[input.length];

        for (int i = input.length - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = input[i];
        }
        System.out.println(String.join(", ", reversed));
    }
}
