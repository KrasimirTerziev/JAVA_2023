package com.telerikacademy.core;

public class MethodVarargsDemo {
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(sum(1));
        System.out.println(sum(1, 2, 3));

        greet("Hello");
        greet("Hi", "Ivan", "Gosho", "Misho");
    }

    static int sum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // varargs should be the last parameter in method
    static void greet(String greeting, String... names) {
        if (names.length == 0) {
            System.out.printf("%s!%n", greeting);
            return;
        }
        for (String name : names) {
            System.out.printf("%s, %s!%n", greeting, name);
        }
    }
}
