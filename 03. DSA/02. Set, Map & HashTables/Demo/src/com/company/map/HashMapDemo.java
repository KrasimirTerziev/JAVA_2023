package com.company.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> studentAgeMap = new HashMap<>();

        studentAgeMap.put("John", 21);
        studentAgeMap.put("Bill", 18);
        studentAgeMap.put("Angel", 21);
        studentAgeMap.put("William", 30);

        System.out.println(studentAgeMap.entrySet());

        Map.Entry<String, Integer> entry = new Map.Entry<String, Integer>() {
            @Override
            public String getKey() {
                return "Chavo";
            }

            @Override
            public Integer getValue() {
                return 1;
            }

            @Override
            public Integer setValue(Integer value) {
                return 1;
            }
        };

        Set<Map.Entry<String, Integer>> entrySet = studentAgeMap.entrySet();
        // It throws UnsupportedOperationException as this Set is made only for iteration
        entrySet.add(entry);

        System.out.println(studentAgeMap.entrySet());
        //{Angel=21, John=21, Bill=18, William=30}

        // find the age of John (the value) via his name (the key)
        System.out.println(studentAgeMap.get("John"));

        // check if the map contains a value with the given key
        System.out.println(studentAgeMap.containsKey("Walter")); // O(1)
        System.out.println(studentAgeMap.containsValue(30)); // O(n)

        // get all values in the map as a collection
        System.out.println(studentAgeMap.values());

        // find the value for the given key. if there is no value, return the default value
        System.out.println(studentAgeMap.getOrDefault("Walter",0));

        // if the key is not in the map, add it with the given value
        studentAgeMap.putIfAbsent("William", 21);
    }
}
