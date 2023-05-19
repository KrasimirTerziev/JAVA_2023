package com.company.dsa.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] items;
    private int top;

    public ArrayStack() {
        items = (E[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    @Override
    public void push(E element) {
        if (top == items.length) {
            resize();
        }

        items[top] = element;
        top++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        top--;
        return items[top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        items = Arrays.copyOf(items, items.length * 2);
    }

}
