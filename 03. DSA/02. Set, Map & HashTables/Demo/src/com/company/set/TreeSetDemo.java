package com.company.set;

import com.company.Employee;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        // the employees are sorted based on the comparator we define
        Set<Employee> employees = new TreeSet<>();
        addEmployeesToSet(employees);
        printSet(employees);

        // the employees are sorted based on the lambda expression by initialization
        Set<Employee> employeesByName = new TreeSet<>(
                Comparator.comparing(Employee::getLastName));
        addEmployeesToSet(employeesByName);
        printSet(employeesByName);

        //Hash table and linked list implementation of the Set interface, with predictable iteration order
        Set<Employee> employeesLinked = new LinkedHashSet<>();
        addEmployeesToSet(employeesLinked);
        printSet(employeesLinked);

    }

    private static void printSet(Set<Employee> employees) {
        System.out.println("*** START OF PRINT ***");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("*** END OF PRINT ***" + System.lineSeparator());
    }

    private static void addEmployeesToSet(Set<Employee> employees) {
        employees.add(new Employee("Zach", "Brown", "Sales"));
        employees.add(new Employee("Tim", "Apple", "Finance"));
        employees.add(new Employee("Tom", "Jeferson", "Transportation"));
        employees.add(new Employee("Andy", "Thompson", "Sales"));
    }
}
