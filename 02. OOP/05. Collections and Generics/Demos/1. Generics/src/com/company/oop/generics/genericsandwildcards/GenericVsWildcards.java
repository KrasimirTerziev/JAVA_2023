package com.company.oop.generics.genericsandwildcards;

import java.util.List;

public class GenericVsWildcards {


    // This signature says that `elements` is a List of Es
    public static <E> void processElementsGeneric(List<E> elements) {

    }

    // This signature says that `elements` is a List of unknown type
    public static void processElementsWildcard(List<?> elements) {

    }

    // --------------------------------------------------------------------------------------------

    // Both mergeWithGenerics and mergeWithWildcard are correct but mergeWithWildcard is more readable.
    public static <T1, T2 extends T1> void mergeWithGenerics(List<T1> destination, List<T2> source) {
        // merge source into destination
    }

    public static <T> void mergeWithWildcard(List<T> destination, List<? extends T> source) {
        // merge source element into destination
    }

}
