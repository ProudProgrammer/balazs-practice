package org.gaborbalazs.practice.coding.leetcode.invertbinarytree;

import java.util.*;

class Solution {

    public TreeNode invertTreeWithList(TreeNode root) {
        List<TreeNode> childNodes = new ArrayList<>();
        childNodes.add(root);
        while (!childNodes.isEmpty()) {
            List<TreeNode> childNodesCopy = new ArrayList<>(childNodes);
            childNodes.clear();
            for (TreeNode treeNode : childNodesCopy) {
                if (treeNode != null) {
                    TreeNode left = treeNode.left;
                    treeNode.left = treeNode.right;
                    treeNode.right = left;
                    childNodes.add(treeNode.left);
                    childNodes.add(treeNode.right);
                }
            }
        }
        return root;
    }

    public TreeNode invertTreeWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }

    public List<Integer> getValuesAsList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();
        childNodes.add(root);
        while (!childNodes.isEmpty()) {
            childNodes.stream().filter(Objects::nonNull).map(treeNode -> treeNode.value).forEach(result::add);
            List<TreeNode> childNodesCopy = new ArrayList<>(childNodes);
            childNodes.clear();
            for (TreeNode treeNode : childNodesCopy) {
                if (treeNode != null) {
                    childNodes.add(treeNode.left);
                    childNodes.add(treeNode.right);
                }
            }
        }
        return result;
    }
}
