package com.company.dsa;

public class PrintPyramid {

    public static void main(String[] args) {
        printTriangle(10);
        //printPyramid(10, 10);
    }

    private static void printTriangle(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(printLineWithLength(n));
        printTriangle(n - 1);
        System.out.println(printLineWithLength(n));
    }

    private static void printPyramid(int n, int max) {
        if (n == 0) {
            System.out.println(printLineWithLength(max - n));
            return;
        }
        System.out.println(printLineWithLength(max - n));
        printPyramid(n - 1, max);
        System.out.println(printLineWithLength(max - n));
    }

    private static String printLineWithLength(int length) {
        return "*".repeat(length);
    }
}
