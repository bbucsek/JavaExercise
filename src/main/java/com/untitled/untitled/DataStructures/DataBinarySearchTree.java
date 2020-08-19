package com.untitled.untitled.DataStructures;

public class DataBinarySearchTree {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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

        public String toString() {
            return "value is: " + value;

        }
    }


    private Node root;
    private int size;

    public DataBinarySearchTree() {
    }

    public DataBinarySearchTree(int value) {
        this.root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        root = addRecursive(root, value);
        size++;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }
        return value < current.value
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    public void delete(int value) {
        deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseTree(Node current) {
        if (current != null) {
            traverseTree(current.left);
            System.out.println(current);
            traverseTree(current.right);
        }
    }



}
