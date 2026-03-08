package org.gaborbalazs.practice.coding.bst;

class BstApp {

    static void main(String[] args) {

        System.out.println(">> main()");

        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.add(10);
        binarySearchTree.add(11);
        binarySearchTree.add(9);
        System.out.println("Max: " + binarySearchTree.max());
        System.out.println("Min: " + binarySearchTree.min());
        System.out.println("Contains 9: " + binarySearchTree.contains(9));
        System.out.println("Contains 8: " + binarySearchTree.contains(8));

        System.out.println("<< main()");
    }
}
