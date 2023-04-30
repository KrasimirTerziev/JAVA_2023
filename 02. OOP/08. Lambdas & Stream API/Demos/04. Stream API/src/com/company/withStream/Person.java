package com.company.withStream;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old", this.name, this.age);
    }
}
