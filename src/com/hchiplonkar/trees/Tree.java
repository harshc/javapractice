package com.hchiplonkar.trees;

import java.util.ArrayList;
import java.util.LinkedList;

class Tree {

    /*
    Create a balanced tree from an array
     */
    private static TreeNode CreateBalancedTree(int[] values, int start, int end) {
        if (end < start) return null;

        int mid = (end + start) / 2;
        TreeNode n = new TreeNode(values[mid]);
        n.left = CreateBalancedTree(values, start, mid - 1);
        n.right = CreateBalancedTree(values, mid + 1, end);

        return n;
    }

    static TreeNode CreateBalancedTree(int[] values) {
        return CreateBalancedTree(values, 0, values.length - 1);
    }

    /*
    Check if a tree is balanced
     */
    private static int CheckHeight(TreeNode root) {
        if (root == null) return 0; // height is 0

        int leftHeight = CheckHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = CheckHeight(root.right);
        if (rightHeight == -1) return -1;

        int difference = Math.abs(leftHeight - rightHeight);
        if (difference > 1) return -1;
        return Math.max(leftHeight, rightHeight);
    }

    static boolean IsTreeBalanced(TreeNode root) {
        return CheckHeight(root) != -1;
    }

    /*
    Create a levelled list of a tree
     */
    static ArrayList<LinkedList<TreeNode>> CreateLevelledListFromTree(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> currentLevel = new LinkedList<>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (currentLevel.size() > 0) {
            result.add(currentLevel);
            LinkedList<TreeNode> parents = currentLevel;
            currentLevel = new LinkedList<>();
            for (TreeNode p : parents) {
                if (p.left != null) currentLevel.add(p.left);
                if (p.right != null) currentLevel.add(p.right);
            }
        }

        return result;
    }
}
