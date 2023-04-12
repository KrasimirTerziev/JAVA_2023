package com.company.core.tasks;
import java.util.Scanner;

public class Navigation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input);
        input = scanner.nextLine();
        int cols = Integer.parseInt(input);
        input = scanner.nextLine();
        int n = Integer.parseInt(input);
        input = scanner.nextLine();
        String[] strArray = input.split(" ");
        int[] targets = new int[n];

        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(strArray[i]);
        }

        int[][] matrix = new int[rows][cols];
        int power2 = 1;

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = power2;
                power2 *= 2;
            }
            power2 = matrix[i][0] * 2;
        }

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.printf("%d ", matrix[i][j]);
//            }
//            System.out.println();
//        }

        int sum = 0;
        int currentRow = rows - 1;
        int currentCol = 0;
        int coeff = Math.max(rows, cols);

        for (int target : targets) {
            int targetRow = target / coeff;
            int targetCol = target % coeff;

            int horizontalDirection = 1;
            if (targetCol < currentCol) {
                horizontalDirection = -1;
            }

            int verticalDirection = 1;
            if (targetRow < currentRow) {
                verticalDirection = -1;
            }

            for (int i = currentCol; i != targetCol; i += horizontalDirection) {
                sum += matrix[currentRow][i];
                matrix[currentRow][i] = 0;
            }

            for (int i = currentRow; i != targetRow; i += verticalDirection) {
                sum += matrix[i][targetCol];
                matrix[i][targetCol] = 0;
            }

            currentRow = targetRow;
            currentCol = targetCol;
        }

        sum += matrix[currentRow][currentCol];
        System.out.println(sum);
    }
}
