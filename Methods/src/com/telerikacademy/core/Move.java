package com.telerikacademy.core;

import java.util.Scanner;
import java.util.Arrays;

public class Move {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
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
    }*/
        Scanner scanner = new Scanner(System.in);

        // Read starting point
        int position = scanner.nextInt();

        // Read array
        String[] arrStr = scanner.next().split(",");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int forwardSum = 0;
        int backwardSum = 0;

        // Read instructions
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                break;
            }
            String[] parts = line.split(" ");
            int steps = Integer.parseInt(parts[0]);
            String direction = parts[1];
            int size = Integer.parseInt(parts[2]);

            // Calculate sums
            if (direction.equals("forward")) {
                for (int i = 1; i <= steps; i++) {
                    position = (position + size) % arr.length;
                    forwardSum += arr[position];
                }
            } else if (direction.equals("backwards")) {
                for (int i = 1; i <= steps; i++) {
                    position = (position - size + arr.length) % arr.length;
                    backwardSum += arr[position];
                }
            }
        }

        // Print results
        System.out.println("Forward: " + forwardSum);
        System.out.println("Backwards: " + backwardSum);
    }
}

