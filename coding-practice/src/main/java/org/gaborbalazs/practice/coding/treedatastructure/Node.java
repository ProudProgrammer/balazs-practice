package org.gaborbalazs.practice.coding.treedatastructure;

public class Node {

    private final Node parent;
    private final int level;

    public Node(Node parent, int level) {
        this.parent = parent;
        this.level = level;
    }

    public Node getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }
}
