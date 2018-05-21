package com.accenture.test;

public class AVLTree {
    private Node root;

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node node) {
        Node left = node.getLeft();
        Node right = left.getRight();

        left.setRight(node);
        node.setLeft(right);

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        left.setHeight(max(height(left.getLeft()), height(left.getRight())) + 1);

        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.getRight();
        Node left = right.getLeft();

        right.setLeft(node);
        node.setRight(left);

        node.setHeight( max(height(node.getLeft()), height(node.getRight())) + 1);
        right.setHeight( max(height(right.getLeft()), height(right.getRight())) + 1);

        return right;
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;

        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value) {
        if (node == null)
            return (new Node(value));

        if (value < node.getValue())
            node.setLeft(insert(node.getLeft(), value));

        else if (value > node.getValue())
            node.setRight( insert(node.getRight(), value));

        else if (value == node.getValue())
            return node;

       node.setHeight( 1 + max(height(node.getLeft()),
                height(node.getRight())));

        int balance = balanceFactor(node);

        if (balance > 1 && value < node.getLeft().getValue())
            return rightRotate(node);

        if (balance < -1 && value > node.getRight().getValue())
            return leftRotate(node);

        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public void balancedTree(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            balancedTree(node.getLeft());
            balancedTree(node.getRight());
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 27);
        tree.root = tree.insert(tree.root, 49);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 67);
        tree.root = tree.insert(tree.root, 59);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 14);

        System.out.println("Árvore balanceada: ");
        tree.balancedTree(tree.root);
    }
}
