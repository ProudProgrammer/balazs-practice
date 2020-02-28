package org.gaborbalazs.practice.coding.treedatastructure;

public class TreeProcessor {

    public Node searchLeastCommonParent(Node node1, Node node2, Root root) {
        int node1Level = getLevel(node1, root);
        int node2Level = getLevel(node2, root);
        Node parent1 = node1.getParent();
        Node parent2 = node2.getParent();
        while (parent1 != parent2) {
            if (node1Level > node2Level) {
                parent1 = parent1.getParent();
                node1Level--;
            } else if (node2Level > node1Level) {
                parent2 = parent2.getParent();
                node2Level--;
            } else {
                parent1 = parent1.getParent();
                parent2 = parent2.getParent();
                node1Level--;
                node2Level--;
            }
        }
        return parent1;
    }

    private int getLevel(Node node, Root root) {
        int level = 0;
        Node actualNode = node;
        while (actualNode != root) {
            actualNode = actualNode.getParent();
            level++;
        }
        return level;
    }
}
