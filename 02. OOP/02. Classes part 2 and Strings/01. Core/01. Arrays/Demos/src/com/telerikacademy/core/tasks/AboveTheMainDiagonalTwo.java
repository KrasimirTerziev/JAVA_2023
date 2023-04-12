package com.telerikacademy.core.tasks;

import java.util.Scanner;

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
- First we add the numbers on the first row (1, 2, 4, 8....)
- The current column value is calculated by multiplying the previous column value by 2
- If the column number (j) is bigger (or equal) than the row number (i) is added to the sum
3. Print sum

The disadvantage of this approach is that we need to store the values in a matrix.
 */
public class AboveTheMainDiagonalTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][] matrix = new long[n][n];
        matrix[0][0] = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0){
                matrix[i][0] = matrix[i - 1][0] * 2;
            }
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] * 2;
                if (j > i) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}