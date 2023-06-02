package com.company.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = {11, 23, 8, 14, 30, 9, 6, 17, 22, 28};
        selectionSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < list[i]) {
                    int t = list[i];
                    list[i] = list[j];
                    list[j] = t;
                }
            }
        }
    }
}
