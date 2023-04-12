package com.company.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "register": {
                    registerUser(usersData, commandArgs);
                    break;
                }
                case "delete": {
                    deleteUser(usersData, commandArgs);
                    break;
                }
            }

            // read next command
            command = scanner.nextLine();
        }
    }

    private static void registerUser(String[][] usersData, String[] commandArgs) {
        // validate arguments
        if (!isValidArgumentsCount(commandArgs, 3)) {
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (!isValidArgumentLength(username, "Username", 3)) {
            return;
        }

        // validate password
        if (!isValidArgumentLength(password, "Password", 3)) {
            return;
        }

        // check if username exists
        if (checkUserExists(username, usersData)) {
            printError("Username already exists.");
            return;
        }

        // find free slot
        int freeSlotIndex = getNextFreeSlotIndex(usersData);
        if (freeSlotIndex == -1) {
            printError("The system supports a maximum number of 4 users.");
            return;
        }

        // save user
        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;
        printSuccess("Registered user.");
    }

    private static void deleteUser(String[][] usersData, String[] commandArgs) {
        // validate arguments
        if (!isValidArgumentsCount(commandArgs, 3)) {
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (!isValidArgumentLength(username, "Username", 3)) {
            return;
        }

        // validate password
        if (!isValidArgumentLength(password, "Password", 3)) {
            return;
        }

        // find account to delete
        int accountIndex = findUserIndex(usersData, username, password);
        if (accountIndex == -1) {
            printError("Invalid account/password.");
            return;
        }

        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;
        printSuccess("Deleted account.");
    }

    static boolean isValidArgumentsCount(String[] arguments, int expectedCount) {
        if (arguments.length < expectedCount) {
            printError("Too few parameters.");
            return false;
        }
        return true;
    }

    static boolean isValidArgumentLength(String argument, String argumentName, int argumentMinLength) {
        if (argument.length() < argumentMinLength) {
            String error = String.format("%s must be at least %d characters long.", argumentName, argumentMinLength);
            printError(error);
            return false;
        }
        return true;
    }

    static boolean checkUserExists(String username, String[][] usersData) {
        for (String[] user : usersData) {
            if (username.equals(user[0])) {
                return true;
            }
        }
        return false;
    }

    static int getNextFreeSlotIndex(String[][] usersData) {
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    static int findUserIndex(String[][] usersData, String username, String password) {
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                return i;
            }
        }
        return -1;
    }

    static void printError(String message) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    static void printSuccess(String message) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
}
