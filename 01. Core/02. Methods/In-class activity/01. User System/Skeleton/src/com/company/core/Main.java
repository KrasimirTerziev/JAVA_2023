package com.company.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "register": {
                    // validate arguments
                    if (commandArgs.length < 3) {
                        System.out.println(ANSI_RED + "Too few parameters." + ANSI_RESET);
                        break;
                    }

                    String username = commandArgs[1];
                    String password = commandArgs[2];

                    // validate username
                    if (username.length() < 3) {
                        System.out.println(ANSI_RED + "Username must be at least 3 characters long." + ANSI_RESET);
                        break;
                    }

                    // validate password
                    if (password.length() < 3) {
                        System.out.println(ANSI_RED + "Password must be at least 3 characters long." + ANSI_RESET);
                        break;
                    }

                    // check if username exists
                    boolean usernameExists = false;
                    for (int i = 0; i < usersData.length; i++) {
                        if (username.equals(usersData[i][0])) {
                            usernameExists = true;
                        }
                    }

                    if (usernameExists) {
                        System.out.println(ANSI_RED + "Username already exists." + ANSI_RESET);
                        break;
                    }

                    // find free slot
                    int freeSlotIndex = -1;
                    for (int i = 0; i < usersData.length; i++) {
                        if (usersData[i][0] == null) {
                            freeSlotIndex = i;
                        }
                    }

                    // no free slots
                    if (freeSlotIndex == -1) {
                        System.out.println(ANSI_RED + "The system supports a maximum number of 4 users." + ANSI_RESET);
                        break;
                    }

                    // save user
                    usersData[freeSlotIndex][0] = username;
                    usersData[freeSlotIndex][1] = password;

                    System.out.println(ANSI_GREEN + "Registered user." + ANSI_RESET);

                    break;
                }
                case "delete": {
                    // validate arguments
                    if (commandArgs.length < 3) {
                        System.out.println(ANSI_RED + "Too few parameters." + ANSI_RESET);
                        break;
                    }

                    String username = commandArgs[1];
                    String password = commandArgs[2];

                    // validate username
                    if (username.length() < 3) {
                        System.out.println(ANSI_RED + "Username must be at least 3 characters long" + ANSI_RESET);
                        break;
                    }

                    // validate password
                    if (password.length() < 3) {
                        System.out.println(ANSI_RED + "Password must be at least 3 characters long." + ANSI_RESET);
                        break;
                    }

                    // find account to delete
                    int accountIndex = -1;
                    for (int i = 0; i < usersData.length; i++) {
                        if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                            accountIndex = i;
                        }
                    }

                    if (accountIndex == -1) {
                        System.out.println(ANSI_RED + "Invalid account/password." + ANSI_RESET);
                        break;
                    }

                    usersData[accountIndex][0] = null;
                    usersData[accountIndex][1] = null;

                    System.out.println(ANSI_GREEN + "Deleted account." + ANSI_RESET);

                    break;
                }
            }

            // read next command
            command = scanner.nextLine();
        }
    }
}
