package com.company.dsa;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeImpl<E extends Comparable<E>> implements BinarySearchTree<E> {
    private E value;
    private BinarySearchTreeImpl<E> left;
    private BinarySearchTreeImpl<E> right;

    public BinarySearchTreeImpl(E value) {
        this.value = value;
        left = null;
        right = null;
    }
    @Override
    public E getRootValue() {

        return value;
    }
    @Override
    public BinarySearchTree<E> getLeftTree() {

        return left;
    }

    @Override
    public BinarySearchTree<E> getRightTree() {

        return right;
    }
    @Override
    public void insert(E value) {
        if (value.compareTo(this.value) < 0) {
            if (left == null) {
                left = new BinarySearchTreeImpl<>(value);
            } else {
                left.insert(value);
            }
        } else if (value.compareTo(this.value) > 0) {
            if (right == null) {
                right = new BinarySearchTreeImpl<>(value);
            } else {
                right.insert(value);
            }

        }
    }
    @Override
    public boolean search(E value) {
        if (value.compareTo(this.value) == 0){
            return true;
        }else if(value.compareTo(this.value) < 0 && left != null){
            return left.search(value);
        }else if(value.compareTo(this.value) > 0 && right != null){
            return right.search(value);
        }
        return false;
    }

    @Override
    public List<E> inOrder() {
        //Връща списък с елементите от дървото.
        //Първо взимаме лявата част, после текущия възел и накрая дясната част.
        List<E> result = new ArrayList<>();

        if(left != null){
            result.addAll(left.inOrder());
        }
        if(value != null){
            result.add(value);
        }
        if(right != null){
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<E> postOrder() {
        //Връща списък с елементите от дървото.
        //Първо взимаме лявата част, после дясната част и накарая текущия възел.
        List<E> result = new ArrayList<>();

        if(left != null){
            result.addAll(left.postOrder());
        }
        if(right != null){
            result.addAll(right.postOrder());
        }
        if(value != null){
            result.add(value);
        }

        return result;
    }

    @Override
    public List<E> preOrder() {
        //Връща списък с елементите от дървото.
        //Първо взимаме текущия възел, после лявата част част и накарая дясната част.
        List<E> result = new ArrayList<>();
        if (value != null){
            result.add(value);
        }
        if (left != null){
            result.addAll(preOrder());
        }
        if (right != null){
            result.addAll(preOrder());
        }
        return result;
    }

    @Override
    public List<E> bfs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int height() {
        if(value == null){
            return 0;
        }
        int leftHeight = 0;
        if(left != null) {
            leftHeight = left.height();
        }
        int rightHeight = 0;
        if(right != null){
            rightHeight = right.height();
        }
        //Взимаме по дългия клон плюс едно, което се явява корена на дървото.
        return Math.max(leftHeight, rightHeight) + 1;
    }

//    Advanced task: implement remove method. To test, uncomment the commented tests in BinaryTreeImplTests
//    @Override
//    public boolean remove(E value) {
//        throw new UnsupportedOperationException();
//    }
}
