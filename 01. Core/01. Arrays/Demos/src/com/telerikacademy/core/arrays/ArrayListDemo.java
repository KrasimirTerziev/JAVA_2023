package com.telerikacademy.core.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        // initialize empty array list (there are no elements at all)
        ArrayList<String> arrayList = new ArrayList<>();

        // add five elements in the array list
        arrayList.add("Ivan");
        arrayList.add("Gosho");
        arrayList.add("Fjord");
        arrayList.add("Gosho");

        //remove all Gosho with break;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!arrayList.remove("S")){
                break;
            }
        }

//        the code below will produce infinite loop
//        for (int i = 0; i < arrayList.size(); i++) {
//            arrayList.add("S");
//        }

        for (String s : arrayList) {
            System.out.println(s);
        }



        // initialize empty array list (there are no elements at all)
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        // add five elements in the array list
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

        for (Integer integer : arrayList1) {
            System.out.println(integer);
        }

        // change element at index
        arrayList1.set(1, 20);

        // initialize array list with 5 elements and values {0, 2, 4, 6, 8}
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList2.add(i * 2);
        }

        // initialize array list from the console where all elements are entered on a single line e.g.
        // 1 2 3 4 5
        System.out.println("Enter array on a single line using space for delimiter:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArray = line.split(" ");
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            arrayList3.add(Integer.parseInt(strArray[i]));
        }

        // print array on the console
        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.printf("%d ", arrayList3.get(i));
        }
        System.out.println();

        //print array on the console
        System.out.println(arrayList3);
    }
}
