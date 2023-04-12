package com.telerikacademy.core.tasks;

import java.util.Scanner;

/*
Reverse Array

You are given an array of numbers. Your task is to reverse it.

Input

Read from the standard input

Receive the numbers on the first line of the input, separated by whitespace.
Output

Print to the standard output

Print the reversed array in a single line. Separate the numbers in the array a comma and whitespace.
Sample tests

Input

1 2 3 4 5 6 7
Output

7, 6, 5, 4, 3, 2, 1

1. Read the input and store in an array
2. Make a for loop to start from the last index to the first
3. Print the result in the for loop
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int[] arrayOfNumbers = new int[array.length];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            arrayOfNumbers[i] = Integer.parseInt(array[i]);
        }

        for (int j = arrayOfNumbers.length - 1; j >= 0; j--) {
            result.append(arrayOfNumbers[j]).append(", ");
        }

        System.out.print(result.substring(0, result.length() - 2));


    }
}
