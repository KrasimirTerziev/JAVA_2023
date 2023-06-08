package com.company.dsa;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(16));
        System.out.println(factorialIterative(16));
        System.out.println(factorialBigInt(BigInteger.valueOf(64)));
    }

    private static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long factorialIterative(long n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static BigInteger factorialBigInt(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        BigInteger numberMinusOne = number.subtract(BigInteger.ONE);
        return number.multiply(factorialBigInt(numberMinusOne));
    }
}
