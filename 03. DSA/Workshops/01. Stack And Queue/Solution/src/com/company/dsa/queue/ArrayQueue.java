package com.company.dsa.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] items;
    private int tail;

    public ArrayQueue() {
        items = (E[]) new Object[DEFAULT_CAPACITY];
        tail = 0;
    }

    @Override
    public void enqueue(E element) {
        if (tail == items.length) {
            resize();
        }
        items[tail] = element;
        tail++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = items[0];
        for (int i = 1; i < tail; i++) {
            items[i - 1] = items[i];
        }
        tail--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[0];
    }

    @Override
    public int size() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        items = Arrays.copyOf(items, items.length * 2);
    }

}
