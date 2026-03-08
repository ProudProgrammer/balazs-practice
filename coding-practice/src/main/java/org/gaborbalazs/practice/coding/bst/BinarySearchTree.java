package org.gaborbalazs.practice.coding.bst;

interface BinarySearchTree<E> {

    void add(E element);
    void remove(E element);
    E min();
    E max();
    boolean contains(E element);
    int size();
    void clear();
}
