package com.company;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {
    public static void main(String[] args) {
        // Convert centigrade to fahrenheit
        Function<Integer, Double> centigradeToFahrenheit = x -> new Double((x * 9 / 5) + 32);
        Double fahrenheit = centigradeToFahrenheit.apply(30);
        System.out.println(fahrenheit);

        // Convert String to Integer
        Function<String, Integer> stringToInteger = x -> Integer.valueOf(x);
        Integer result = stringToInteger.apply("42");
        System.out.println(result);

        // Double a value
        Function<Integer, Integer> doubleValue = x -> x * 2;
        System.out.println(doubleValue.apply(4));

        // Double a value using UnaryOperator
        UnaryOperator<Integer> doubleValueUnary = x -> x * 2;
        System.out.println(doubleValueUnary.apply(4));
    }
}
