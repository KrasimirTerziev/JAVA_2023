package com.company;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        // Lambda to check if a String is valid (not null, not empty and not blank
        Predicate<String> isStringValid = s -> s != null && !s.isEmpty() && !s.isBlank();
        System.out.printf("Is {} valid?: %b%n", isStringValid.test(null));
        System.out.printf("Is {\"\"} valid?: %b%n", isStringValid.test(""));
        System.out.printf("Is {\"Apple\"} valid?: %b%n", isStringValid.test("Apple"));
    }
}
