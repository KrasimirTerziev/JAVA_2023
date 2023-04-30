package com.company.withStream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var elements = List.of("Best", "New", "Company", "Best", "25 Java");
        var people = List.of(new Person(21, "John"), new Person(30, "Bob"));

        System.out.println(countUniqueStrings(elements));
        System.out.println(validateListContains(elements, "Company"));
        System.out.println(extractElementsWithLeadingDigit(elements));
        System.out.println(transformElementsToUppercase(elements));
        System.out.println(extractPeoplesIntroductions(people));
        System.out.println(concatenateList(elements, ","));
    }

    public static long countUniqueStrings(List<String> strings) {
        return strings
                .stream()
                .distinct()
                .count();
    }

    public static boolean validateListContains(List<String> strings, String target) {
        return strings
                .stream()
                .anyMatch(s -> s.equals(target));
    }

    public static List<String> extractElementsWithLeadingDigit(List<String> strings) {
        return strings
                .stream()
                .filter(s -> Character.isDigit(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<String> transformElementsToUppercase(List<String> strings) {
        return strings
                .stream()
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
    }

    public static String extractPeoplesIntroductions(List<Person> people) {
        return people
                .stream()
                .map(person -> person.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static String concatenateList(List<String> strings, String delimiter) {
        return strings
                .stream()
                .reduce("", (accumulator, next) -> accumulator + next + delimiter);

        // {"One", "Two", "Three"} -> "One Two Three"
    }

    public static int sumElements(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, (sum, next) -> sum + next);
        // {1, 2, 3} -> 1+2+3 = 6
    }

    public static int sumElementsWithLoop(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
