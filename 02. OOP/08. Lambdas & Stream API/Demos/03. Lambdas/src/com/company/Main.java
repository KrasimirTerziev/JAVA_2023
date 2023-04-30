package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(generatePeople());

        // Use lambda to implement comparator in order to sort items
        people.sort((Person person1, Person person2) -> {
            return Integer.compare(person1.getAge(), person2.getAge());
        });

        // Use lambda with no parameter type syntax to implement comparator in order to sort items
        people.sort((person1, person2) -> {
            //more code
            //more more code
            return Integer.compare(person1.getAge(), person2.getAge());
        });

        // Use lambda expression to implement comparator in order to sort items
        people.sort((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));
    }

    private static List<Person> generatePeople() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 21));
        people.add(new Person("Frank", 42));
        people.add(new Person("Patric", 25));

        return people;
    }
}
