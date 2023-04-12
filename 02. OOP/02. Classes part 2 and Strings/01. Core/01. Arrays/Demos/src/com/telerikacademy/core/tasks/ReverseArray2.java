package com.telerikacademy.core.tasks;

import java.util.Scanner;

public class ReverseArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (int i = input.length - 1; i > 0; i--) {
            System.out.printf("%s, ", input[i]);
        }
        System.out.print(input[0]);
    }
}
