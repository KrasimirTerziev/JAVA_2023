package com.telerikacademy.core;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (int i = inputArr.length - 1; i >= 0; i--) {
            arr.add(inputArr[i]);
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i < arr.size() - 1) {
                System.out.print(", ");
            }
        }
    }


}

