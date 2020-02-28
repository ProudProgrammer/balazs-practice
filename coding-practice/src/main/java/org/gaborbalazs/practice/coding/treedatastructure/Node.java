package org.gaborbalazs.practice.coding.treedatastructure;

public class Node {

    private final Node parent;

    public Node(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}
