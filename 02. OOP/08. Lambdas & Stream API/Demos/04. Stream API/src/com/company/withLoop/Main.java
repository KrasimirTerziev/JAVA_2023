package com.company.withLoop;

import java.util.ArrayList;
import java.util.List;

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
        var seen = new ArrayList<String>();

        for (String string : strings) {
            if (!seen.contains(string)) seen.add(string);
        }

        return seen.size();
    }

    public static boolean validateListContains(List<String> strings, String target) {
        for (String string : strings) {
            if (string.equals(target)) {
                return true;
            }
        }

        return false;
    }

    public static List<String> extractElementsWithLeadingDigit(List<String> strings) {
        var withNumbers = new ArrayList<String>();

        for (String value : strings) {
            if (Character.isDigit(value.charAt(0))) {
                withNumbers.add(value);
            }
        }

        return withNumbers;
    }

    public static List<String> transformElementsToUppercase(List<String> strings) {
        var upperCase = new ArrayList<String>();

        for (String string : strings) {
            String uppercaseString = string.toUpperCase();
            upperCase.add(uppercaseString);
        }

        return upperCase;
    }

    public static String extractPeoplesIntroductions(List<Person> people) {
        var peopleIntroductions = new ArrayList<String>();

        for (Person person : people) {
            peopleIntroductions.add(person.toString());
        }

        StringBuilder sb = new StringBuilder();

        for (String introduction : peopleIntroductions) {
            sb.append(introduction).append(System.lineSeparator());
        }

        return sb.toString();
    }


    public static String concatenateList(List<String> strings, String delimiter) {
        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.append(string).append(delimiter);
        }

        return sb.toString();
    }
}
