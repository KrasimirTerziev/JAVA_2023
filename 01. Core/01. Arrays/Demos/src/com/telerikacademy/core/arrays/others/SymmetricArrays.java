package com.telerikacademy.core;


import java.util.Scanner;

public class SymmetricArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            boolean isSymetric = true;

            for (int j = 0; j <= input.length / 2; j++) {
                if (!input[j].equals(input[input.length - 1 - j])) {
                    isSymetric = false;
                    break;
                }
            }
            if (isSymetric) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }


    }
}

