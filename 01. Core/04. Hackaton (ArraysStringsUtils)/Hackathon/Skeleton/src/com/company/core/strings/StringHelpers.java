package com.company.core.strings;

@SuppressWarnings("StringConcatenationInLoop")
public class StringHelpers {

    public static String abbreviate(String source, int maxLength) {
        String current;
        for (int i = 0; i < maxLength; i++) {
            current += source.charAt(i);
        }
        String dots = "...";
        if (maxLength > 0) {
            String result = current + dots;
            return result;
        } else {
            return result;
        }
    }

    public static String capitalize(String source) {
        if (source.length == 0) {
            return "";
        } else {
            String result = source.substring(0, 1).toUpperCase() + source.substring(1);
            return result;
        }
    }

    public static String concat(String string1, String string2) {
        String result = string1 + string2;
        return result;
    }

    public static boolean contains(String source, char symbol) {
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == symbol) {
                return true;
            }
        }
        return false;
    }

    public static boolean endsWith(String source, char target) {
        if (source.charAt(source.length() - 1) == target) {
            return true;
        }
        return false;
    }

}

    public static int firstIndexOf(String source, char target) {
        //Kaloyan
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(String source, char symbol) {
        //Kaloyan
        for (int i = source.length() - 1; i >= 0; i--) {
            if (source.charAt(i) == symbol) {
                return i;
            }
        }
        return -1;
    }

    public static String padStart(String source, int length, char paddingSymbol) {
        String stars = "";
        int len = source.length();
        for (int i = 0; i < length - len/2; i++) {
            stars += paddingSymbol;
        }
        stars += source;
        for (int i = 0; i < length - len/2; i++) {
            stars += paddingSymbol;
        }
        return stars;

    }

    public static String padEnd(String source, int length, char paddingSymbol) {
        String stars = source;
        int len = source.length();
        for (int i = 0; i < length - len; i++) {
            stars += paddingSymbol;
        }
        return stars;

    }
    public static String padStart(String source, int length, char paddingSymbol) {
        String stars = "";
        int len = source.length();
        for (int i = 0; i < length - len; i++) {
            stars += paddingSymbol;
        }
        stars += source;
        return stars;

    }

    public static String repeat(String source, int times) {
        String repeated = "";
        for (int i = 0; i < times; i++) {
            repeated += source;
        }
        return repeated;
    }

    public static String reverse(String source) {
        String reversed = "";

        for (int i = source.length() - 1; i >= 0; i--) {
            reversed = reversed + source.charAt(i);
        }

        return reversed;
    }

    public static String section(String source, int start, int end) {
        int all = end - start;

        String sectioned = "";


        for (int i = start; i < end + 1; i++) {
            sectioned = sectioned + source.charAt(i);
        }

        return sectioned;

    }

}

public static boolean startsWith(String source,char target){
        if(source.charAt(0)==tarhet){
        return true;
        }
        return false;
        }

        }
