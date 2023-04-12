package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

//        BoardItem item = new BoardItem("Refactor this mess", LocalDate.now().plusDays(2));
//        item.setDueDate(item.getDueDate().plusYears(2));
//        item.setTitle("Not that important");
//        item.revertStatus();
//        item.advanceStatus();
//        item.revertStatus();
//
//        item.displayHistory();
//
//        System.out.println("\n--------------\n");
//
//        BoardItem anotherItem = new BoardItem("Don't refactor anything",  LocalDate.now().plusDays(10));
//        anotherItem.advanceStatus();
//        anotherItem.advanceStatus();
//        anotherItem.advanceStatus();
//        anotherItem.advanceStatus();
//        anotherItem.advanceStatus();
//        anotherItem.displayHistory();
//

//        Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
//        System.out.println(task.getTitle());    // Test the application flow
//        System.out.println(task.getDueDate());  // 2020-09-16
//        System.out.println(task.getStatus());   // To Do
//        System.out.println(task.getAssignee()); // Pesho

//        Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
//        task.advanceStatus();
//        task.advanceStatus();
//        task.setAssignee("Gosho");
//        task.displayHistory();

//        Issue issue = new Issue(
//                "App flow tests?",
//                "We need to test the App!",
//                LocalDate.now().plusDays(1));
//        issue.advanceStatus();
//        issue.setDueDate(issue.getDueDate().plusDays(1));
//        issue.displayHistory();



        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        Task task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems());




    }

}
