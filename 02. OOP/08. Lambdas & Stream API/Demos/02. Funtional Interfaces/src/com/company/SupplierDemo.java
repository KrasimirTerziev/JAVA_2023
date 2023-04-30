package com.company;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // A function to generate a random value
        Supplier<Double> generateRandomValue = () -> Math.random();
        Double randomValue = generateRandomValue.get();
        System.out.println(randomValue);
    }
}
