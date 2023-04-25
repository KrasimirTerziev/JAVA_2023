package com.company.oop.generics.livedemo;

public class MyArrayList<T> {

    private static final int DEFAULT_SIZE = 10;

    private T[] data;

    private int size = 0;

    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public void add(T element) {
        //check if data is full then make bigger data array
        data[size] = element;
        size++;
    }

    public T get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }
}
