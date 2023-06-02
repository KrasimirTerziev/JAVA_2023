package com.company.dsa;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        the tree:
           8
          / \
         66  5
            / \
           3   9

         */
        TreeNode<Integer> root = new TreeNode<>(8);
        TreeNode<Integer> anotherNode = new TreeNode<>(5,
                List.of(new TreeNode<>(3), new TreeNode<>(9)));
        root.children = List.of(new TreeNode<>(66), anotherNode);

        //root.bfs();
        //root.dfs();

        BinaryTreeNode<Integer> binaryTreeRoot = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> binaryTreeAnotherNode = new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(3),
                new BinaryTreeNode<>(9));
        binaryTreeRoot.left = new BinaryTreeNode<>(66);
        binaryTreeRoot.right = binaryTreeAnotherNode;

        //binaryTreeRoot.bfs();

        System.out.println("Preorder:");
        binaryTreeRoot.dfsPreOrder();
        System.out.println();
        System.out.println("~~~");

        System.out.println("Postorder:");
        binaryTreeRoot.dfsPostOrder();
        System.out.println();
        System.out.println("~~~");

        System.out.println("Inorder:");
        binaryTreeRoot.dfsInOrder();
    }
}
