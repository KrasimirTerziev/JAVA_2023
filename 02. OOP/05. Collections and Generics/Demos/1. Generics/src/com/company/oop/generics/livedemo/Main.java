package com.company.oop.generics.livedemo;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myIntList = new MyArrayList<>();
        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(3);
        //myIntList.add("Four"); //Not OK
        //myIntList.add(true);

        System.out.println(myIntList.get(2));
        System.out.println(join(myIntList));
        System.out.println(sum(myIntList));

        MyArrayList<String> myStringList = new MyArrayList<>();
        myStringList.add("One");
        myStringList.add("Two");
        myStringList.add("Three");
        System.out.println(join(myStringList));
        //System.out.println(sum(myStringList));

        System.out.println(myStringList.get(2));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        //arrayList.add("Four");

        Collections.sort(arrayList);

        int a = 10;
    }

    public static String join(MyArrayList<?> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            result.append(" ");
        }
        return result.toString();
    }

    //do we need ?
    // Integer <- Number   (CORRECT)
    // ArrayList<Integer> <- ArrayList<Number>    (WRONG)
    public static Number sum(MyArrayList<? extends Number> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result + (double) list.get(i);
        }
        return result;
    }
}
