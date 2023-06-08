package com.company.dsa;

import java.util.*;

public class SmallWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String lines = sc.next();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Character.getNumericValue(lines.charAt(j));
            }
        }

        boolean[][] visited = new boolean[row][col];

        List<Integer> conquestSizes = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j);
                    conquestSizes.add(size);
                }
            }
        }

        Collections.sort(conquestSizes, Collections.reverseOrder());

        for (int size : conquestSizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int N = matrix.length;
        int M = matrix[0].length;

        if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col] || matrix[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;

        int size = 1;
        size += dfs(matrix, visited, row - 1, col);
        size += dfs(matrix, visited, row + 1, col);
        size += dfs(matrix, visited, row, col - 1);
        size += dfs(matrix, visited, row, col + 1);

        return size;
    }
}