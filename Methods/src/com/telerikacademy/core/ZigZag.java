package com.telerikacademy.core;

import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int step = 3;
        long sum = 0;
        int firstNum = 1;
        int current;

        for (int row = 0; row < N; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < M; col += 2) {
                    if (col == 0) {
                        current = firstNum;
                    } else {
                        if (row > 0) {
                            current = col * step + firstNum;
                        } else {
                            current = col * step + 1;
                        }
                    }
                    if (row == 0 || col == 0 || col == N - 1) {
                        sum += current;
                    } else {
                        sum += current * 2;
                    }
                }
            } else {
                for (int col = 1; col < M; col += 2) {
                    if (col == 1) {
                        current = firstNum + step;
                    } else {
                        current = col * step + firstNum;
                    }
                    if (row == N - 1 || col == M - 1 || row == M - 1) {
                        sum += current;
                    } else {
                        sum += current * 2;
                    }
                }
            }
            firstNum += 3;
        }
        System.out.println(sum);
    }
}
