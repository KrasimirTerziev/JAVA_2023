package com.company.map;

import com.company.Employee;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {
    public static void main(String[] args) {
        Map<Employee, Integer> employeeAgeMap = new HashMap<>();

        employeeAgeMap.put(new Employee("Ivan", "Ivanov", "Sales"), 22);
        employeeAgeMap.put(new Employee("Ivan", "Petrov", "Sales"), 32);


        // if Employee does not override equals() and hashCode() Ivan Ivanov will be added again to the Map
        employeeAgeMap.put(new Employee("Ivan", "Ivanov", "Sales"), 22);

        System.out.println(employeeAgeMap.entrySet().size());
    }
}
