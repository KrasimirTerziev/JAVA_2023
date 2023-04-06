package com.telerikacademy.core;

import java.util.Scanner;
public class LongestBlockInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int max = 1;
        int curr = 1;
        String repeatChars = "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                curr++;
            } else {
                if (curr > max) {
                    max = curr;
                    repeatChars = str.substring(i - curr, i);
                }
                curr = 1;
            }
        }
        if (curr > max) {
            max = curr;
            repeatChars = str.substring(str.length() - curr, str.length());
        }
        System.out.println(repeatChars);

    }
}
