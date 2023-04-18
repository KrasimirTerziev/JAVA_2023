package com.company.oop.staticvsinstancevariables;

public class GoogleEmployee {
    static String companyName = "Google";

    private final String employeeName;
    private final int yearsOfService;
    private final double salary;

    public GoogleEmployee(String employeeName, int yearsOfService, double salary) {
        this.employeeName = employeeName;
        this.yearsOfService = yearsOfService;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return String.format("%s %s", GoogleEmployee.companyName, employeeName);
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double getSalary() {
        return salary;
    }
}
