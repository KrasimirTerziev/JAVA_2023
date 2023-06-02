package com.company.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T> {

    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void bfs() {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public void dfsPreOrder() {
        System.out.print(value + " ");
        if (left != null) {
            left.dfsPreOrder();
        }
        if (right != null) {
            right.dfsPreOrder();
        }
    }

    public void dfsPostOrder() {

        if (left != null) {
            left.dfsPostOrder();
        }
        if (right != null) {
            right.dfsPostOrder();
        }
        System.out.print(value + " ");
    }

    public void dfsInOrder() {
        if (left != null) {
            left.dfsInOrder();
        }
        System.out.print(value + " ");
        if (right != null) {
            right.dfsInOrder();
        }
    }
}
