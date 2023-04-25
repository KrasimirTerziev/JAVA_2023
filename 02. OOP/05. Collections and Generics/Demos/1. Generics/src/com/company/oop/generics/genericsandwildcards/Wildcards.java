package com.company.oop.generics.genericsandwildcards;

import java.util.List;

public class Wildcards {

    // <?> essentially matches anything (i.e. any object can be passed to this method)
    public void printListUnbound(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // `list` can contain anything that extends Number
    public static void printListUpperbound(List<? extends Number> list) {
        for (Number o : list) {
            System.out.println(o);
        }
    }

}
