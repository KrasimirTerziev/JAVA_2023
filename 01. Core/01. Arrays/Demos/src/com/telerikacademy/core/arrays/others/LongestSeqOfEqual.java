package com.telerikacademy.core;
import java.util.Scanner;

public class LongestSeqOfEqual {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxLength = 0;
        int current = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]){
                current++;
            }else{
                maxLength = Math.max(maxLength, current);
                current = 1;
            }
        }
        maxLength = Math.max(maxLength, current);
        System.out.println(maxLength);
    }
}
