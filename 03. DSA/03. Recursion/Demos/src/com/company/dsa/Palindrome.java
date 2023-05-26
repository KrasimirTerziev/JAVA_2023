package com.company.dsa;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Company"));
        System.out.println(isPalindrome("123454321"));
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        if (len == 0 || len == 1) {
            return true;
        }
        return str.charAt(0) == str.charAt(len - 1) && isPalindrome(str.substring(1, len - 1));
    }
}
