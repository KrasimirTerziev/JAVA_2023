package com.telerikacademy.core;

import java.util.Scanner;
import java.util.Arrays;

public class Move {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        String secondLine = scanner.nextLine();
        String[] stringArr = secondLine.split(",");
        int[] arr = new int[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            arr[i] = Integer.valueOf(stringArr[i]);
        }

        int forward = 0;
        int backwords = 0;

        while (true) {
            String exit = scanner.nextLine();
            if (exit.equals("exit")) {
                break;
            }
            String[] current = exit.split(" ");
            int steps = Integer.parseInt(current[0]);
            String direction = current[1];
            int size = Integer.parseInt((current[2]));

            if (direction.equals("forward")) {
                for (int i = 1; i <= steps; i++) {
                    if (steps == 0) {
                        break;
                    }
                    start = (start + size) % arr.length;
                    forward += arr[start];
                    steps--;
                }
            } else if (direction.equals("backwards")) {
                for (int i = 1; i <= steps; i++) {
                    if (steps == 0) {
                        break;
                    }
                    start = (start - size + arr.length) % arr.length;
                    backwords += arr[start];
                    steps--;
                }
            }
        }
        System.out.println("Forward: " + forward);
        System.out.println("Backwards: " + backwords);
    }
}


