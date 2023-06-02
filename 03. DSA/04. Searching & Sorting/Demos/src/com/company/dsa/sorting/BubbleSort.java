package com.company.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {11, 23, 8, 14, 30, 9, 6, 17, 22, 28};
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void bubbleSort(int[] list) {
        boolean inOrder = false;
        while (!inOrder) {
            inOrder = true;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    int t = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = t;
                    inOrder = false;
                }
            }
        }
    }
}
