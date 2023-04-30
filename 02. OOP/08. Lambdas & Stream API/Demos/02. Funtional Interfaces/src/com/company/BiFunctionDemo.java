package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BiFunctionDemo {
    public static void main(String[] args) {
        // Format Price Label
        BiFunction<Double, String, String> formatPrice = (price, item) -> String.format("%s costs $%.2f", item, price);
        String formattedPrice = formatPrice.apply(12.0, "Book");
        System.out.println(formattedPrice);

        // Get length of the longer String
        BiFunction<String, String, Integer> getLongerStringLength = (s1, s2) -> Math.max(s1.length(), s2.length());
        Integer maxLength = getLongerStringLength.apply("Banana", "Apple");
        System.out.println(maxLength);

        // Get length of the longer String using BinaryOperator
        BinaryOperator<String> getLongerString = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;
        String longerString = getLongerString.apply("Banana", "Apple");
        System.out.println(longerString);

        // Combine two lists of equal length using a BiFunction
        List<String> names = List.of("John", "Frank", "Jimmy");
        List<Integer> ids = List.of(38, 42, 11);
        List<String> namesWithIds = combineLists(names, ids, (name, id) -> name + id);
        System.out.println(namesWithIds);
    }

    /**
     * A method that takes in two lists and produces a new list, the combination of the other two, using the <code>combiner</code>.
     *
     * @param combiner A function of type <code>BiFunction</code> that combines the two lists
     * @param <T>      The type of the left list
     * @param <U>      The type of the right list
     * @param <R>      The return type
     * @return A new list produced from combining each elements from <code>leftList</code> with elements from <code>rightList</code>
     */
    public static <T, U, R> List<R> combineLists(List<T> leftList, List<U> rightList, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < leftList.size(); i++) {
            result.add(combiner.apply(leftList.get(i), rightList.get(i)));
        }
        return result;
    }
}
