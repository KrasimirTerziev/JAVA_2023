package com.company.hashtable;

import com.company.Employee;

public class Main {
    public static void main(String[] args) {
        String Elica = "elica";
        String Elica2 = new String("elica");
        String Alice = "alice";

        System.out.println(Elica.hashCode());
        System.out.println(Elica2.hashCode());
        System.out.println(Alice.hashCode());

        HashTable hashTable = new HashTable();

        hashTable.put("Ivan", "Sales");
        hashTable.put("Petar", "Marketing");
        hashTable.put("Gosho", "Marketing");
        hashTable.put("Dimitar", "Sales");

        hashTable.put("Ivan", "Marketing");

        System.out.println(hashTable);

        HashTable2 hashTable2 = new HashTable2();

        hashTable2.put(new Employee("Ivan", "Ivanov", "Sales"), "Nikolai");
        hashTable2.put(new Employee("Ivan", "Ivanov", "Sales"), "Nikolai");
    }
}
