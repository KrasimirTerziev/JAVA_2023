package com.company.dsa;

public class PrintStars {

    public static void main(String[] args) {
        printStarsIterative(5);

        System.out.println();

        printStarsRecursive(5);
    }
    public static void printStarsIterative(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
    }

    public static void printStarsRecursive(int n) {
        if (n == 1) {
            System.out.print("*");
            return;
        }

        System.out.print("*");
        printStarsRecursive(n - 1);
    }
}
