package org.gaborbalazs.practice.coding.bst;

class BinarySearchTreeImpl implements BinarySearchTree<Integer> {

    private int size;
    private Node root;

    @Override
    public void add(Integer value) {
        if (value == null) {
            return;
        }
        if (root == null) {
            root = new Node(value);
            size++;
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return; // duplicate, ignore
            }
        }
        Node newNode = new Node(value);
        newNode.parent = parent;
        if (value < parent.value) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
        size++;
    }

    @Override
    public void remove(Integer element) {

    }

    @Override
    public Integer min() {
        if (root == null) {
            return null;
        }
        return minNode(root).value;
    }

    @Override
    public Integer max() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current.value;
    }

    @Override
    public boolean contains(Integer element) {
        if (element == null) {
            return false;
        }
        return findNode(element) != null;
    }

    private Node findNode(Integer element) {
        Node current = root;
        while (current != null) {
            if (element < current.value) {
                current = current.leftChild;
            } else if (element > current.value) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    private Node minNode(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    private static class Node {

        private Integer value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }
    }
}
