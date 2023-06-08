package com.company.dsa;

public class PrintRecursive {
    
    public static void main(String[] args) {
        printNumbers(5);
    }
    
    private static void printNumbers(int n) {
        System.out.println("This is the start of recursivePrintCall: " + n);
        if (n == 0) {
            System.out.println("This is the bottom of the recursion!");
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
        //System.out.println(n);
        System.out.println("This is recursivePrintCall: " + n + " end");
    }
}
