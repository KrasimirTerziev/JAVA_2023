package com.company.dsa;

import java.util.Scanner;
//
//public class Sequence {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int k = sc.nextInt();
//        int n = sc.nextInt();
//
//        int result = calculateNthMember(k, n);
//
//        System.out.println(result);
//    }
//
//    public static int calculateNthMember(int k, int n) {
//        if (n == 1) {
//            return k;
//        }
//        if (n % 2 == 0) {
//            return 2 * calculateNthMember(k, n / 2 - 1) + 1;
//        } else {
//            return calculateNthMember(k, n - 1) + 1;
//        }
//    }
//}
//import java.util.Scanner;
//
//public class Sequence {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int k = sc.nextInt();
//        int n = sc.nextInt();
//
//        int result = k;
//
//        for (int i = 2; i <= n; i++) {
//            if (i % 2 == 0) {
//                result = 2 * result + 1;
//            } else {
//                result = result + 1;
//            }
//        }
//        System.out.println(result);
//    }
//
//}
//import java.util.Scanner;
//
//public class Sequence {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int K = sc.nextInt();
//        int N = sc.nextInt();
//
//        int[] sequence = new int[N + 1];
//        sequence[1] = K;
//
//        for (int i = 2; i <= N; i++) {
//            if (i % 2 == 0) {
//                sequence[i] = sequence[i / 2] + 1;
//            } else {
//                sequence[i] = 2 * sequence[(i - 1) / 2] + 1;
//            }
//        }
//
//        System.out.println(sequence[N]);
//    }
//}

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        if (n == 1) {
            System.out.println(k);
        }
        if (n == 2) {
            System.out.println(k + 1);
        }
        if (n == 3) {
            System.out.println(2 * k + 1);
        }

        int[] sequence = new int[n + 1];
        sequence[1] = k;
        sequence[2] = k + 1;
        sequence[3] = 2 * k + 1;
        sequence[4] = k + 2;

        for (int i = 5; i <= n; i++) {
            if (i % 3 == 0) {
                sequence[i] = 2 * sequence[i / 3] + 1;
            } else if (i % 3 == 1) {
                sequence[i] = sequence[i / 3] + 2;
            } else {
                sequence[i] = sequence[i / 3 + 1] + 1;
            }
        }
        System.out.println(sequence[n]);
    }
}



