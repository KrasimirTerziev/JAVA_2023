package com.company.dsa.queue;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    @Override
    public void enqueue(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        tail = node;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E element = head.data;
        head = head.next;
        size --;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
