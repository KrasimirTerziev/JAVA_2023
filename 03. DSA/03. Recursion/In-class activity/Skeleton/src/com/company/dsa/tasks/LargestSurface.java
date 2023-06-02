package com.company.dsa.tasks;

import java.util.Scanner;

/*
5 6
1 3 2 2 2 4
3 3 3 2 4 4
4 3 1 2 3 3
4 3 1 3 3 1
4 3 3 3 1 1
 */
public class LargestSurface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];//false, false

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int maxSteps = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col]) {
                    int steps = solve(matrix, visited, row, col, matrix[row][col]);
                    maxSteps = Math.max(steps, maxSteps);
                }
            }
        }
        System.out.println(maxSteps);
    }

    private static int solve(int[][] matrix, boolean[][] visited, int row, int col, int target) {
        if (isOutOfMatrix(matrix.length, matrix[0].length, row, col)) {
            return 0;
        }

        if (visited[row][col]) {
            return 0;
        }

        if (matrix[row][col] != target) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + solve(matrix, visited, row, col - 1, target) +
                solve(matrix, visited, row, col + 1, target) +
                solve(matrix, visited, row - 1, col, target) +
                solve(matrix, visited, row + 1, col, target);
    }

    private static boolean isOutOfMatrix(int rowLength, int colLength, int row, int col) {
        return (row < 0 || row >= rowLength || col < 0 || col >= colLength);
    }
}
