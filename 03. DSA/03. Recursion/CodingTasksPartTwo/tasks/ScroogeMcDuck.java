package tasks;

import java.util.Scanner;

public class ScroogeMcDuck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] size = input.split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String inputElement = scanner.next();
                int element = Integer.parseInt(inputElement);
                matrix[i][j] = element;
            }
        }
        int totalCoins = collectCoins(matrix);
        System.out.println(totalCoins);
    }

    public static int collectCoins(int[][] matrix) {
        int totalCoins = 0;
        boolean hasCoins = true;

        while (hasCoins) {
            int maxCoins = 0;
            int maxRow = 0;
            int maxCol = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] > maxCoins) {
                        maxCoins = matrix[i][j];
                        maxRow = i;
                        maxCol = j;
                    }

                }
            }
            if (maxCoins > 0) {
                totalCoins += maxCoins;
                matrix[maxRow][maxCol] = 0;

                if (maxRow - 1 >= 0 && matrix[maxRow - 1][maxCol] < maxCoins)
                    matrix[maxRow - 1][maxCol] = maxCoins;
                if (maxRow + 1 < matrix.length && matrix[maxRow + 1][maxCol] < maxCoins)
                    matrix[maxRow + 1][maxCol] = maxCoins;
                if (maxCol - 1 >= 0 && matrix[maxRow][maxCol - 1] < maxCoins)
                    matrix[maxRow][maxCol - 1] = maxCoins;
                if (maxCol + 1 < matrix[0].length && matrix[maxRow][maxCol + 1] < maxCoins)
                    matrix[maxRow][maxCol + 1] = maxCoins;
            } else {
                hasCoins = false;
            }
        }
        return totalCoins;
    }
}