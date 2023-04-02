package com.telerikacademy.core;

import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxSeq = 1;
        int currSeq = 1;
        int prev = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int current = sc.nextInt();
            if (current > prev) {
                currSeq++;
            } else {
                currSeq = 1;
            }
            maxSeq = Math.max(maxSeq, currSeq);
            prev = current;
        }
        System.out.println(maxSeq);
    }
}


