package com.company.oop.generics.genericsbasics;

import com.company.oop.generics.models.Person;

public class Main {

    public static void main(String[] args) {
        // Creating MyGenericList<Integer> is possible because MyGenericListImpl is implemented via generic types
        MyGenericList<Integer> numbers = new MyGenericListImpl<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.print("All numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        // Creating MyGenericList<Person> is possible because MyGenericListImpl is implemented via generic types
        MyGenericList<Person> people = new MyGenericListImpl<>();

        people.add(new Person("Pesho", 45));
        people.add(new Person("Vladi", 34));
        people.add(new Person("Todor", 35));

        System.out.print("All people: ");
        for (Person person : people) {
            System.out.print(person + " ");
        }
    }

    public static <E> void arrayToList(E[] array, MyGenericList<E> list) {
        for (E element : array) {
            list.add(element);
        }
    }
}
