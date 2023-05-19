package com.company.dsa;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {
    }

    public LinkedList(Iterable<T> iterable) {
        iterable.forEach(this::addLast);
    }

    @Override
    public void addFirst(T value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T value) {

        Node newNode = new Node(value);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node current = getNode(index);
            Node previous = current.prev;

            newNode.prev = previous;
            newNode.next = current;

            previous.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no element.");
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no element.");
        }
        return tail.value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    @Override
    public int indexOf(T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no element.");
        }
        T output = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return output;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no element.");
        }
        T output = tail.value;
        if(size == 0){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return output;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
