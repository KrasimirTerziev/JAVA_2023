package com.company.core.tasks;

import java.util.Scanner;

public class Bounce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parameters = input.split(" ");
        int rows = Integer.parseInt(parameters[0]);
        int cols = Integer.parseInt(parameters[1]);

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (long) Math.pow(2, i + j);
            }
        }

        if (rows == 1 || cols == 1) {
            System.out.println(1);
            return;
        }

        long sum = 1;
        int currentRow = 0;
        int currentCol = 0;
        int horizontalDirection = 1;
        int verticalDirection = 1;

        while (true) {
            currentRow += verticalDirection;
            currentCol += horizontalDirection;

            if (currentRow == rows - 1 || currentRow == 0) {
                verticalDirection *= -1;
            }

            if (currentCol == cols - 1 || currentCol == 0) {
                horizontalDirection *= -1;
            }

            sum += matrix[currentRow][currentCol];

            if ((currentRow == 0 && currentCol == 0) ||
                    (currentRow == 0 && currentCol == cols - 1) ||
                    (currentRow == rows - 1 && currentCol == 0) ||
                    (currentRow == rows - 1 && currentCol == cols - 1)) {
                break;
            }
        }
        System.out.println(sum);
    }
}
