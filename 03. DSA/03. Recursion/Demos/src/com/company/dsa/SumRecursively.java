package com.company.dsa;

public class SumRecursively {
    
    public static void main(String[] args) {
        System.out.println(sumRecursively(5));
    }
    
    private static int sumRecursively(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = n + sumRecursively(n - 1);
        System.out.println("Sum so far: " + sum);
        return sum;
    }
}
