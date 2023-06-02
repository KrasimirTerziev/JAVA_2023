package com.company.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T> {

    T value;
    List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, List<TreeNode<T>> children) {
        this.value = value;
        this.children = children;
    }

    public void bfs() {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");
            queue.addAll(current.children);
        }
    }

    public void dfs() {
        System.out.print(value + " ");
        for (TreeNode<T> child : children) {
            child.dfs();
        }
    }
}
