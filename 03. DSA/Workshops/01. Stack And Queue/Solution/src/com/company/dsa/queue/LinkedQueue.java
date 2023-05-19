package com.company.dsa.queue;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>();
        newNode.data = element;
        newNode.next = null;
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
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
