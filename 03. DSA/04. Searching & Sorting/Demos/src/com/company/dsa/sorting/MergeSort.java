package com.company.dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = {11, 23, 8, 14, 30, 9, 6, 17, 22, 28};
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void mergeSort(int[] list) {
        mergeSortRec(list, 0, list.length - 1);
    }

    private static void mergeSortRec(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }

        int middleIndex = (start + end) / 2;
        mergeSortRec(list, start, middleIndex);
        mergeSortRec(list, middleIndex + 1, end);
        merge(list, start, middleIndex, end);
    }

    private static void merge(int[] list, int start, int middle, int end) {
        int[] mergedArr = new int[end - start + 1];

        int leftIndex = start;
        int rightIndex = middle + 1;
        int mergeIndex = 0;

        while (leftIndex <= middle && rightIndex <= end) {
            if (list[leftIndex] < list[rightIndex]) {
                mergedArr[mergeIndex++] = list[leftIndex++];
            } else {
                mergedArr[mergeIndex++] = list[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            mergedArr[mergeIndex++] = list[leftIndex++];
        }
        while (rightIndex <= end) {
            mergedArr[mergeIndex++] = list[rightIndex++];
        }

        for (int i = 0; i < mergedArr.length; i++) {
            list[start + i] = mergedArr[i];
        }
    }
}