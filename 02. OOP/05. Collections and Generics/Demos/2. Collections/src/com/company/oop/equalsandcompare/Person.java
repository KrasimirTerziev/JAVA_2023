package com.company.oop.equalsandcompare;

// with ctrl + click on Comparable see how this interface is declared using generics
// because of that we can write Comparable<Person> here and after implementing the method compareTo()
// we can compare different persons
public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // when equals() is not overridden base functionality (from Object) is used
    // equals() in Object compares addresses i.e. it uses ==
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d}", name, age);
    }
}
