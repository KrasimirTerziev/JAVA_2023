package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        // Consumer to print a number
        Consumer<Integer> print = a -> System.out.println(a);
        print.accept(42);

        // Consumer to print a list of numbers
        Consumer<List<Integer>> printList = list -> {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        };
        printList.accept(List.of(1, 22, 333, 4444));

        // Consumer to multiply by 2 every integer of an array
        Consumer<int[]> modify = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = 2 * array[i];
            }
        };
        int[] numbers = {1, 2, 3};
        modify.accept(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
