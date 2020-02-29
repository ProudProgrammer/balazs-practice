package org.gaborbalazs.practice.coding.treedatastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeProcessorTest {

    private TreeProcessor underTest;
    private Map<String, Node> nodes;

    @Before
    public void setUp() {
        underTest = new TreeProcessor();
        nodes = getNodes();
    }

    @Test
    public void testWhenNodesOnSameLeafAndSameLevel() {
        // GIVEN
        Node node1 = nodes.get("F");
        Node node2 = nodes.get("G");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("B");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesOnSameLeafAndDifferentLevel() {
        // GIVEN
        Node node1 = nodes.get("H");
        Node node2 = nodes.get("G");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("B");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesOnDifferentLeafAndSameLevel() {
        // GIVEN
        Node node1 = nodes.get("E");
        Node node2 = nodes.get("D");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("A");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesOnDifferentLeafAndDifferentLevel() {
        // GIVEN
        Node node1 = nodes.get("H");
        Node node2 = nodes.get("D");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("A");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesInParentChildRelation() {
        // GIVEN
        Node node1 = nodes.get("F");
        Node node2 = nodes.get("H");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("B");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesAreTheSame() {
        // GIVEN
        Node node1 = nodes.get("G");
        Node node2 = nodes.get("G");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("B");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenRootIsTheDirectCommonParent() {
        // GIVEN
        Node node1 = nodes.get("B");
        Node node2 = nodes.get("C");
        Root root = (Root) nodes.get("A");
        Node expectedLeastCommonParent = nodes.get("A");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertEquals(expectedLeastCommonParent, result);
    }

    @Test
    public void testWhenNodesAreTheRoot() {
        // GIVEN
        Node node1 = nodes.get("A");
        Node node2 = nodes.get("A");
        Root root = (Root) nodes.get("A");

        // WHEN
        Node result = underTest.searchLeastCommonParent(node1, node2, root);

        // THEN
        assertNull(result);
    }

    private Map<String, Node> getNodes() {
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("A", new Root());
        nodes.put("B", new Node(nodes.get("A")));
        nodes.put("C", new Node(nodes.get("A")));
        nodes.put("D", new Node(nodes.get("C")));
        nodes.put("E", new Node(nodes.get("B")));
        nodes.put("F", new Node(nodes.get("B")));
        nodes.put("G", new Node(nodes.get("B")));
        nodes.put("H", new Node(nodes.get("F")));
        return nodes;
    }
}