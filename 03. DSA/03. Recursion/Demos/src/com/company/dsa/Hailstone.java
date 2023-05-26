package com.company.dsa;

public class Hailstone {

    public static void main(String[] args) {
        hailstone(17);
    }

    public static void hailstone(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            hailstone(n / 2);
        } else {
            hailstone(3 * n + 1);
        }
    }
}
