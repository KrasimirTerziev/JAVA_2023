package com.company.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {

    public static void main(String[] args) {
        // Compare the three implementations with example input 45
        int number = 5;

        int[] fibonacciNumbers = new int[number + 1];
        fibonacciArrayMemoization(number, fibonacciNumbers);
        System.out.println(Arrays
                .stream(fibonacciNumbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(",")));

//        List<Integer> fibonacciList = new ArrayList<>();
//        fibonacciListMemoization(number, fibonacciList);
//        System.out.println(fibonacciList
//                .stream()
//                .map(x -> Integer.toString(x))
//                .collect(Collectors.joining(",")));
    }

    private static int fibonacci(int n, int[] fibonacciNumbers) {
        if (n == 0 || n == 1) {
            fibonacciNumbers[n] = 1;
        } else {
            fibonacciNumbers[n] = fibonacci(n - 1, fibonacciNumbers) + fibonacci(n - 2, fibonacciNumbers);
        }
        return fibonacciNumbers[n];
    }

    private static int fibonacciArrayMemoization(int n, int[] fibonacciNumbers) {
        if (fibonacciNumbers[n] == 0) {
            if (n == 0 || n == 1) {
                fibonacciNumbers[n] = 1;
            } else {
                fibonacciNumbers[n] =
                        fibonacciArrayMemoization(n - 1, fibonacciNumbers)
                                + fibonacciArrayMemoization(n - 2, fibonacciNumbers);
            }
        }
        return fibonacciNumbers[n];
    }

    private static int fibonacciListMemoization(int n, List<Integer> fibonacciList) {
        if (n < fibonacciList.size()) {
            return fibonacciList.get(n);
        }

        if (n == 0 || n == 1) {
            fibonacciList.add(1);
        } else {
            int next = fibonacciListMemoization(n - 2, fibonacciList) + fibonacciListMemoization(n - 1, fibonacciList);
            fibonacciList.add(next);
        }

        return fibonacciList.get(fibonacciList.size() - 1);
    }
}
