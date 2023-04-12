package com.telerikacademy.core.tasks;
/*
Above the Main Diagonal

Description

You are given a number N. Using it, create a square matrix of numbers, formed by powers of 2 and find the sum of the numbers above the main diagonal, excluding the diagonal itself.

Input

Read from the standard input.

On the first line, read the number N - the number of rows and columns.
Output

Print to the standard output.

On a single line print the sum of the numbers above the main diagonal excluding the diagonal.
Constraints

N can get as big as 30.
Sample tests

Input

4
Output

70
Explanation

With N equal to 4, we will have a matrix that looks like this:

 1  2  4  8
 2  4  8 16
 4  8 16 32
 8 16 32 64
The main diagonal is 1 4 16 64, so the sum of the numbers above it: 2 + 4 + 8 + 8 + 16 + 32 = 70.

1. Read the input N
2. Nested Loop to get the sum of numbers above the diagonal
- Each cell equals 2 on the power of i + j
- If the column number (j) is bigger (or equal) than the row number (i) is added to the sum
3. Print sum

The advantage of this approach is that we don't need to store the values in a matrix.
 */

import java.util.Scanner;

public class AboveTheMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long sum = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j >= i){
                    sum += (long) Math.pow(2, i + j);
                }
            }
        }

        System.out.println(sum);

    }
}
