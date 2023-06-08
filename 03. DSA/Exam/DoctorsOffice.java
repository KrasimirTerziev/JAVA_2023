package com.company.dsa;

import java.util.LinkedList;
import java.util.Scanner;

import java.util.*;

public class DoctorsOffice {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }

            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("Append")) {
                String name = parts[1];
                queue.addLast(name);
                System.out.println("OK");
            } else if (action.equals("Insert")) {
                int position = Integer.parseInt(parts[1]);
                String name = parts[2];

                if (position < 0 || position > queue.size()) {
                    System.out.println("Error");
                } else {
                    queue.add(position, name);
                    System.out.println("OK");
                }
            } else if (action.equals("Find")) {
                String name = parts[1];
                int count = 0;

                for (String person : queue) {
                    if (person.equals(name)) {
                        count++;
                    }
                }

                System.out.println(count);
            } else if (action.equals("Examine")) {
                int count = Integer.parseInt(parts[1]);

                if (count > queue.size()) {
                    System.out.println("Error");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.print(queue.pop() + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}

//import java.util.LinkedList;
//import java.util.Scanner;
//public class DoctorsOffice {
//    public static void main(String[] args) {
//        LinkedList<String> queue = new LinkedList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        String command = scanner.nextLine();
//        while (!command.equals("End")) {
//
//            String[] parts = command.split(" ");
//            String action = parts[0];
//
//            if (action.equals("Append")) {
//                String name = parts[1];
//                queue.addLast(name);
//                System.out.println("OK");
//            } else if (action.equals("Insert")) {
//                int position = Integer.parseInt(parts[1]);
//                String name = parts[2];
//
//                if (position < 0 || position > queue.size()) {
//                    System.out.println("Error");
//                } else if (position == 0) {
//                    queue.addFirst(name);
//                    System.out.println("OK");
//                } else if (position == queue.size()) {
//                    queue.addLast(name);
//                    System.out.println("OK");
//                } else {
//                    queue.add(name);
//                    System.out.println("OK");
//                }
//            } else if (action.equals("Find")) {
//                String name = parts[1];
//                int count = 0;
//
//                for (String person : queue) {
//                    if (person.equals(name)) {
//                        count++;
//                    }
//                }
//                System.out.println(count);
//            } else if (action.equals("Examine")) {
//                int count = Integer.parseInt(parts[1]);
//
//                if (count > queue.size()) {
//                    System.out.println("Error");
//                } else {
//                    for (int i = 0; i < count; i++) {
//                        System.out.print(queue.pop() + " ");
//                    }
//                    System.out.println();
//                }
//            }
//            command = scanner.nextLine();
//        }
//    }
//}