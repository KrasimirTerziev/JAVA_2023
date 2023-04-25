package com.company.oop.generics.boundedgenerics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Polymorphism at work. A list of Nameables can contain both Product and User
        // since both implement the interface.
        List<Nameable> nameables = new ArrayList<>();
        nameables.add(new Product("Toothpaste", 2.20));
        nameables.add(new User(20, "Pesho"));
        nameables.add(new Product("Shampoo", 4.99));
        nameables.add(new User(21, "Vladi"));
    }

    // We are restricting the generic `E` to something that implements/extends the
    // Nameable interface. This allows us to use the `getName()` method that
    // the Nameable interface provides.
    public static <E extends Nameable> int getLengthOfLongestName(List<E> list) {
        int longest = 0;
        for (E item : list) {
            longest = Math.max(longest, item.getName().length());
        }
        return longest;
    }
}
