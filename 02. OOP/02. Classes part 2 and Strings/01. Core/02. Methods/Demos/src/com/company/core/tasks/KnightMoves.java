package com.company.core.tasks;

import java.util.Scanner;

public class KnightMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        int[][] nextpositions = {
                {-2, -2, -1, -1, 1, 1, 2, 2},
                {-1, 1, -2, 2, -2, 2, -1, 1}
        };

        int stepCount = 1;
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    currentRow = i;
                    currentCol = j;

                    while (true) {
                        board[currentRow][currentCol] = stepCount;
                        stepCount++;

                        boolean nextPositionFound = false;
                        for (int k = 0; k < 8; k++) {
                            int nextRow = currentRow + nextpositions[0][k];
                            int nextCol = currentCol + nextpositions[1][k];
                            if (isNextCellValid(nextRow, nextCol, board)) {
                                currentRow = nextRow;
                                currentCol = nextCol;
                                nextPositionFound = true;
                                break;
                            }
                        }

                        if (!nextPositionFound) {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isNextCellValid(int row, int col, int[][] board) {
        return row >= 0 && row < board.length
                && col >= 0 && col < board.length
                && board[row][col] == 0;
    }
}
