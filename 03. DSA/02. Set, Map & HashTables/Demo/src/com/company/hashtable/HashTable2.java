package com.company.hashtable;

import com.company.Employee;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable2 {
    private final LinkedList<KeyValuePair>[] elements;

    public HashTable2() {
        elements = new LinkedList[10];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public void put(Employee key, String value) {
        int index = getIndex(key);
        for (KeyValuePair element : elements[index]) {
            if (element.key.equals(key)) {
                return;
            }
        }
        elements[index].add(new KeyValuePair(key, value));
    }

    public String get(Employee key) {
        int index = getIndex(key);
        for (KeyValuePair element : elements[index]) {
            if (element.key.equals(key)) {
                return element.value;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<KeyValuePair> list : elements) {
            for (KeyValuePair element : list) {
                result.append(String.format("(%s: %s)%n", element.key, element.value));
            }
        }
        return result.toString();
    }

    private int getIndex(Employee key) {
        int index = Math.abs(key.hashCode()) % elements.length;
        System.out.printf("Then we calculate the index - %d %s",
                index,
                System.lineSeparator());
        return index;
    }

    private class KeyValuePair {
        Employee key;
        String value;

        KeyValuePair(Employee key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
