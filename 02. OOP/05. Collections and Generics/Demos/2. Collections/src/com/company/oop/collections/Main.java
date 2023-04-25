package com.company.oop.collections;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyIntegerList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // The following line will produce an error since,
        // at this point, the list has reached its maximum capacity.
        //list.add(6);

        System.out.printf("Element at index 1: %d%n", list.get(1));

        System.out.print("All elements: ");
        // We can iterate with foreach because MyList is extending Iterable<Integer>.
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
