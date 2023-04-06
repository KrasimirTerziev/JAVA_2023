package com.telerikacademy.core;

import java.util.Scanner;
import java.util.ArrayList;

public class PrimeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> primeNum = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                int divisor = i % j;
                if (divisor == 0) {
                    count++;
                }
            }
            if (count <= 2) {
                primeNum.add(i);
            }
        }
        for (int row = 0; row < primeNum.size(); row++) {
            for (int col = 1; col <= primeNum.get(row); col++) {

                if (primeNum.contains(col)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
