package com.telerikacademy.core;

import java.util.ArrayList;
import java.util.Scanner;

public class BigNumber {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);

        //Take size.
        String input = sc.nextLine();
        String[] arrOfStrings = input.split(" ");
        int[] arr = new int[arrOfStrings.length];
        for (int i = 0; i < arrOfStrings.length; i++) {
            arr[i] = Integer.parseInt(arrOfStrings[i]);
        }

        //Take first array.
        int[] firstArr = new int[arr[0]];
        String inputSecondLine = sc.nextLine();
        String[] arrSecondLineInput = inputSecondLine.split(" ");
        for (int i = 0; i < arrSecondLineInput.length; i++) {
            firstArr[i] = Integer.parseInt(arrSecondLineInput[i]);
        }

        //Take second array.
        int[] secondArr = new int[arr[1]];
        String inputThirdLine = sc.nextLine();
        String[] arrThirdLineInput = inputThirdLine.split(" ");
        for (int i = 0; i < arrThirdLineInput.length; i++) {
            secondArr[i] = Integer.parseInt(arrThirdLineInput[i]);
        }

        //Sum elements of arrays.
        ArrayList<Integer> finalArray = new ArrayList<>();
        int length = Math.max(firstArr.length, secondArr.length);
        for (int i = 0; i < length; i++) {
            int sum = 0;
            if (i < firstArr.length) {
                sum += firstArr[i];
            }
            if (i < secondArr.length) {
                sum += secondArr[i];
            }
            finalArray.add(sum);
        }

        //Create the output.
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < finalArray.size(); i += 2) {
            int curr = finalArray.get(i);
            int next = finalArray.get(i + 1);
            if(finalArray.get(i) > 9){
                curr = curr % 10;
                next = next + 1;
                output.add(curr);
                output.add(next);
                continue;
            }
            output.add(curr);
            output.add(next);
        }

        //Print output.
        for(int i = 0; i < output.size(); i++){
            System.out.printf(output.get(i) + " ");
        } */
        Scanner scanner = new Scanner(System.in);
        String sizes = scanner.nextLine();
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        String[] sizesArray = sizes.split(" ");
        String[] array1 = one.split(" ");
        String[] array2 = two.split(" ");

        int[] sizesNums = new int[sizesArray.length];
        for (int i = 0; i < sizesArray.length; i++) {
            sizesNums[i] = Integer.parseInt(sizesArray[i]);
        }

        int[] numArray1 = new int[sizesNums[0]];
        for (int i = 0; i < sizesNums[0]; i++) {
            numArray1[i] = Integer.parseInt(array1[i]);
        }

        int[] numArray2 = new int[sizesNums[1]];
        for (int i = 0; i < sizesNums[1]; i++) {
            numArray2[i] = Integer.parseInt(array2[i]);
        }

        ArrayList<String> digitsArray = new ArrayList<>();

        int maxLength = Math.max(numArray1.length, numArray2.length);
        int reminder = 0;

        for (int i = 0; i < maxLength; i++) {
            int numArray1CurrentNumber = 0;
            if (i < numArray1.length) {
                numArray1CurrentNumber = numArray1[i];
            }

            int numArray2CurrentNumber = 0;
            if (i < numArray2.length) {
                numArray2CurrentNumber = numArray2[i];
            }

            int digitSum = numArray1CurrentNumber + numArray2CurrentNumber + reminder;
            if (digitSum <= 9) {
                digitsArray.add(String.valueOf(digitSum));
                reminder = 0;
            } else {
                int currentDigit = digitSum % 10;
                digitsArray.add(String.valueOf(currentDigit));
                reminder = 1;
            }

        }

        String outputString = String.join(" ", digitsArray);
        System.out.println(outputString);

    }
}


