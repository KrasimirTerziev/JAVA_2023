package com.company.dsa.tasks;

import java.util.Scanner;

public class ScroogeMcDuck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        int startingRow = 0;
        int startingCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int coins = scanner.nextInt();
                if (coins == 0) {
                    startingRow = row;
                    startingCol = col;
                }
                matrix[row][col] = coins;
            }
        }
//        System.out.println(getMaxStepsWithRecursion(matrix, startingRow, startingCol));
        System.out.println(getMaxStepsWithLoop(matrix, startingRow, startingCol));
    }

    private static int getMaxStepsWithLoop(int[][] matrix, int currentRow, int currentCol) {
        int nextStepCoins = 0;
        int nextRow = -1;
        int nextCol = -1;
        int maxSteps = 0;

        while (true) {
            if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] > nextStepCoins) {
                nextStepCoins = matrix[currentRow][currentCol - 1];
                nextRow = currentRow;
                nextCol = currentCol - 1;
            }

            if (currentCol + 1 < matrix[0].length && matrix[currentRow][currentCol + 1] > nextStepCoins) {
                nextStepCoins = matrix[currentRow][currentCol + 1];
                nextRow = currentRow;
                nextCol = currentCol + 1;
            }

            if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] > nextStepCoins) {
                nextStepCoins = matrix[currentRow - 1][currentCol];
                nextRow = currentRow - 1;
                nextCol = currentCol;
            }

            if (currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol] > nextStepCoins) {
                nextStepCoins = matrix[currentRow + 1][currentCol];
                nextRow = currentRow + 1;
                nextCol = currentCol;
            }

            if (nextStepCoins == 0) {
                return maxSteps;
            }

            matrix[nextRow][nextCol]--;
            maxSteps++;
            currentRow = nextRow;
            currentCol = nextCol;
            nextStepCoins = 0;
        }
    }

    //left, right, up, down
    private static int getMaxStepsWithRecursion(int[][] matrix, int currentRow, int currentCol) {
        int nextStepCoins = 0;
        int nextRow = -1;
        int nextCol = -1;

        if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] > nextStepCoins) {
            nextStepCoins = matrix[currentRow][currentCol - 1];
            nextRow = currentRow;
            nextCol = currentCol - 1;
        }

        if (currentCol + 1 < matrix[0].length && matrix[currentRow][currentCol + 1] > nextStepCoins) {
            nextStepCoins = matrix[currentRow][currentCol + 1];
            nextRow = currentRow;
            nextCol = currentCol + 1;
        }

        if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] > nextStepCoins) {
            nextStepCoins = matrix[currentRow - 1][currentCol];
            nextRow = currentRow - 1;
            nextCol = currentCol;
        }

        if (currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol] > nextStepCoins) {
            nextStepCoins = matrix[currentRow + 1][currentCol];
            nextRow = currentRow + 1;
            nextCol = currentCol;
        }

        if (nextStepCoins == 0) {
            return 0;
        }

        matrix[nextRow][nextCol]--;
        return getMaxStepsWithRecursion(matrix, nextRow, nextCol) + 1;
    }
}