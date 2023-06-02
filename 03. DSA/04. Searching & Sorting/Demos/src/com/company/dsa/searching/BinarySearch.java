package com.company.dsa.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {6, 8, 9, 11, 14, 17, 22, 23, 25, 28, 30};
        System.out.println(binarySearch(22, list));
    }

    public static int binarySearch(int x, int[] list) {
        return binarySearchRec(x, list, 0, list.length - 1);
    }

    public static int binarySearchRec(int x, int[] list, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        if (list[middleIndex] == x) {
            return middleIndex;
        }
        if (x < list[middleIndex]) {
            return binarySearchRec(x, list, startIndex, middleIndex - 1);
        }

        return binarySearchRec(x, list, middleIndex + 1, endIndex);
    }
}
