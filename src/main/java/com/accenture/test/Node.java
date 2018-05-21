package com.accenture.test;


public class Node {
    private int value;
    private int height;
    private Node left;
    private Node right;

    public Node(int d) {
        value = d;
        height = 1;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
