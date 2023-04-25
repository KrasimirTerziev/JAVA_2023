package com.company.oop;

import java.util.Arrays;
import java.util.Iterator;

public class MyListImpl<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 4;
    private T[] data;
    private int size = 0;

    public MyListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public MyListImpl(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public int capacity() {
        return data.length; // не съм сигурен дали не трябва да връща size.
    }

    @Override
    public void add(T element) {
        if (size >= capacity()) {
            T[] newData = Arrays.copyOf(data, capacity() * 2);
            data = newData;
        }
        data[size] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int lastIndexOf(T element) {
        for (int i = data.length - 1; i >= 0; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAt(int index) {
        T[] output = (T[]) new Object[data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals(data[index])) {
                output[i] = data[i];
            }
        }
    }

    @Override
    public boolean remove(T element) {
        T[] output = (T[]) new Object[data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals(element)) {
                output[i] = data[i];
            }
        }
        if (data.length > output.length) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(data, null);
    }

    @Override
    public void swap(int from, int to) {
        T first = data[from];
        data[from] = data[to];
        data[to] = first;
    }

    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i] + ", ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
