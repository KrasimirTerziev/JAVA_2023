package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 5, 8, 3, 7, 1));
        list.sort(new Comparator<>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return Integer.compare(integer1, integer2);
            }
        });

        Comparator<Integer> myComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        list.sort(myComparator);
    }
}
