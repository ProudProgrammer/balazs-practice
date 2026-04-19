package org.gaborbalazs.practice.coding.leetcode.invertbinarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private Solution underTest;

    @BeforeEach
    void setUp() {
        underTest = new Solution();
    }

    @Test
    void shouldReturnTreeAsListWithValues() {
        TreeNode root = createRoot();
        List<Integer> expected = List.of(4, 2, 7, 1, 3, 6, 9);

        List<Integer> result = underTest.getValuesAsList(root);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnInvertedTreeWithValuesUsingList() {
        TreeNode root = createRoot();
        List<Integer> expected = List.of(4, 7, 2, 9, 6, 3, 1);

        TreeNode inverted = underTest.invertTreeWithList(root);
        List<Integer> result = underTest.getValuesAsList(inverted);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnInvertedTreeWithValuesUsingQueue() {
        TreeNode root = createRoot();
        List<Integer> expected = List.of(4, 7, 2, 9, 6, 3, 1);

        TreeNode inverted = underTest.invertTreeWithQueue(root);
        List<Integer> result = underTest.getValuesAsList(inverted);

        assertEquals(expected, result);
    }

    private TreeNode createRoot() {
        return new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
    }
}
