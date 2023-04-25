package com.company.oop.equalsandcompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person pesho = new Person("Pesho", 34);
        Person gosho = new Person("Gosho", 45);
        Person misho = new Person("Misho", 17);

        people.add(pesho);
        people.add(gosho);
        people.add(misho);

        Person pesho2 = new Person("Pesho", 34);
        if (!people.contains(pesho2)) {
            // If we delete the equals() method in person contains() will return false,
            // and pesho2 will be added to the list - why?
            people.add(pesho2);
        }

        // Sort requires that Person objects are comparable,
        // thus, if we remove Comparable from the Person class, sort won't work.
        Collections.sort(people);
        Collections.sort(people, new PersonComparator());

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
