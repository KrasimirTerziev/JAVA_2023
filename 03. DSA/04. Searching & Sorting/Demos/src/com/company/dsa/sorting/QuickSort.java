package com.company.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {11, 23, 8, 14, 30, 9, 6, 17, 22, 28};
        quickSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void quickSort(int[] list) {
        quickSortRec(list, 0, list.length - 1);
    }

    private static void quickSortRec(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = partition(list, start, end);
        quickSortRec(list, start, partitionIndex - 1);
        quickSortRec(list, partitionIndex, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];

        while (start <= end) {
            while (array[start] < pivot) {
                start++;
            }

            while (array[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;

                start++;
                end--;
            }
        }

        return start;
    }
}
