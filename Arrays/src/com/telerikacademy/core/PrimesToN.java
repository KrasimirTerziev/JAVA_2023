package com.telerikacademy.core;
import java.util.ArrayList;
import java.util.Scanner;
public class PrimesToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        if(num > 1){
            arr.add(1);
        }

        for(int i = 2; i <= num; i++ ){
            boolean isPrime = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                arr.add(i);
            }
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.printf(arr.get(i) + " ");
        }
    }
}
