package com.telerikacademy.core.datatypes;

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        // byte, short, int, long
        // float, double
        // char
        // boolean

        byte oneTwoSeven = 127;

        int one = 1;
        int one2 = 1;

        int[] arr1 = {1,2,3}; // [I@2c8d66b2
        int[] arr2 = {1,2,3}; // [I@5a39699c

        System.out.println(one == one2); //compare primitive types --> true (1,1)
        System.out.println(arr1 == arr2); //compare reference types --> false ([I@2c8d66b2,[I@5a39699c)
        System.out.println(arr1[0] == arr2[1]); //compare primitive types --> true (1,1)

        arr2 = arr1;
        //[I@2c8d66b2
        System.out.println(arr1 == arr2); //compare reference types --> true

    }
}
