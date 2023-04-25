package com.company.oop.generics.genericsandwildcards;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        List<Number> numbersList = List.of(1, 2, 3);
        List<Integer> integersList = List.of(4, 5, 6);
        System.out.println(mergeLists(numbersList, integersList));

        // If you uncomment the following line, you will see that we get an error.
        // Since Number does not extend Integer, we cannot use the Integer list as T1.
        // System.out.println(mergeLists(integersList, numbersList));
    }

    // Declare two generic parameters T1 and T2.
    // By specifying that T2 extends T1, we ensure that we can merge list2 into list1.
    public static <T1, T2 extends T1> List<T1> mergeLists(List<T1> list1, List<T2> list2) {
        List<T1> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }
}
