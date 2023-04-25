package com.company.oop.generics.genericsbasics;

import java.util.Iterator;

public class MyGenericListImpl<E> implements MyGenericList<E> {
    private static final int DEFAULT_CAPACITY = 5;

    private final E[] elements;
    private int size;

    public MyGenericListImpl() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E element) {
        elements[size] = element;
        size++;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        int currentIndex;

        MyArrayListIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            E result = elements[currentIndex];
            currentIndex++;
            return result;
        }
    }
}
