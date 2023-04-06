package com.telerikacademy.core;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][];

        for(int i = 0; i < n; i++){
           String line = sc.nextLine();
           String[] nums = line.split(" ");
           arr[n] = new int[nums.length];
           for(int j = 0; i < nums.length; i ++){
               arr[n][i] = Integer.parseInt(nums[i]);
           }
        }

        for(int row = 0; row < arr.length; row ++){
            for(int col = 0; col < arr[row].length; col ++){
                System.out.println(arr[row][col]);
            }
        }

    }
}