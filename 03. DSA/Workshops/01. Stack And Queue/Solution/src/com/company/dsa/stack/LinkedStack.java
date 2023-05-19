package com.company.dsa.stack;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>();
        newNode.data = element;
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = top.data;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.data;
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
