package com.company;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String department;

    public Employee(String firstName, String lastName, String department) {
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    // compareTo is required so that Employee can be used in TreeSet or TreeMap
    @Override
    public int compareTo(Employee employee) {
        return Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName)
                .thenComparing(Employee::getDepartment)
                .compare(this, employee);
    }

    // equals() and hashCode() are required if we want to use Employee as a key in HashSet or HashMap
    // By default the equals() compares the references.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && department.equals(employee.department);
    }

    // equals() and hashCode() are required if we want to use Employee as a key in HashSet or HashMap
    // By default the hashCode() returns an integer that represents the internal memory address of the object.
    @Override
    public int hashCode() {
        int hashCode = Objects.hash(firstName, lastName, department);
        System.out.printf("First we calculate the hash code of the %s object - %d %s",
                this.getClass().getSimpleName(),
                hashCode,
                System.lineSeparator());
        return hashCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
