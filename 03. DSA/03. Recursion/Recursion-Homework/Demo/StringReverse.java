package com.company.dsa;

public class StringReverse {
    
    public static void main(String[] args) {
        String input = "CompanyNinjas";
        System.out.println(stringReverse(input));
    }
    
    private static String stringReverse(String text) {
        int length = text.length();
        if (length == 0) {
            return text;
        }
        return text.substring(length - 1) + stringReverse(text.substring(0, length - 1));
    }
}
