package com.company.oop.collections;

import java.util.Iterator;

public class MyIntegerList implements MyList {
    private static final int DEFAULT_CAPACITY = 5;

    private final int[] elements;
    private int size;

    public MyIntegerList() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(int element) {
        elements[size] = element;
        size++;
    }

    @Override
    public int get(int index) {
        return elements[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<Integer> {
        private int currentIndex;

        MyArrayListIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            int currentElement = elements[currentIndex];
            currentIndex++;
            return currentElement;
        }
    }
}
