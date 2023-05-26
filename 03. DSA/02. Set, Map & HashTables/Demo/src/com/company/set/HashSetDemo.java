package com.company.set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Jimmy");
        names.add("Chandler");
        names.add("Chris");

        // prints 3
        System.out.println(names.size());

        // "Jimmy" is already in the set, nothing changes
        names.add("Jimmy");

        // prints 3
        System.out.println(names.size());

        // add() returns boolean - true if the element was added and false if not
        System.out.println(names.add("Zach"));// true
        System.out.println(names.add("Jimmy"));// false

        Set<String> moreNames = new HashSet<>();
        moreNames.add("Jimmy");
        moreNames.add("Frank");

        // retainAll() returns all elements that appear on bot sets
        moreNames.retainAll(names);
        System.out.println(moreNames);

        // since the Set interface inherits from Collection, we can use it in a stream
        Set<String> namesWithS = names
                .stream()
                .filter(name -> name.contains("C"))
                .collect(Collectors.toSet());

        System.out.println(namesWithS);
    }
}
