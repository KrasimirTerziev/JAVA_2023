package com.company.oop.staticvsinstancevariables;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Pesho");
        Person p2 = new Person("Gosho");
        System.out.println(p1.getId());
        System.out.println(Person.getPeopleCount());

        //access static member using the class name
        System.out.println(GoogleEmployee.companyName);

        //access instance member using object
        GoogleEmployee employee = new GoogleEmployee("Gosho", 4, 1000);
        System.out.println(employee.getEmployeeName());
    }
}
