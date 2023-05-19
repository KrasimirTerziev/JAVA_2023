package com.company.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsDemo {
    public static void main(String[] args) {
        arrayListDemo();
        //linkedListDemo();
    }

    static void arrayListDemo() {
        List<Integer> arrayList = new ArrayList<>(4);

        // add() adds at the end
        arrayList.add(1); // O(1)
        arrayList.add(2); // O(1)
        arrayList.add(3); // O(1)
        arrayList.add(4); // O(1)
        arrayList.add(5); // O(n) - array is resized
        arrayList.add(6); // O(1)

        arrayList.add(0, 0); // O(n)

        System.out.println(arrayList.get(4)); // O(1)

        arrayList.remove(0); // O(n)
        arrayList.remove(arrayList.size() - 1); // O(1)

        System.out.println(arrayList.contains(5)); // O(n)
    }

    static void linkedListDemo() {
        List<Integer> arrayList = new LinkedList<>();

        // add() adds at the end
        arrayList.add(1); // O(1)
        arrayList.add(2); // O(1)
        arrayList.add(3); // O(1)
        arrayList.add(4); // O(1)
        arrayList.add(5); // O(1)
        arrayList.add(6); // O(1)

        arrayList.add(0, 0); // O(1)

        System.out.println(arrayList.get(4)); // O(n)

        arrayList.remove(0); // O(1)
        arrayList.remove(arrayList.size() - 1); // O(1)

        System.out.println(arrayList.contains(5)); // O(n)
    }
}
