package com.hchiplonkar.trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeTest {
    private int[] values = {15, 25, 20, 53, 44, 5, 78, 98, 4, 10, 11, 25, 34};

    @Test
    public void TestCreateBalancedTree() {
        TreeNode result = Tree.CreateBalancedTree(values);
        Assert.assertEquals(result.data, values[6]);
        Assert.assertEquals(result.left.data, values[2]);
        Assert.assertEquals(result.right.data, values[9]);
    }

    @Test
    public void TestCheckHeight() {
        TreeNode result = Tree.CreateBalancedTree(values);
        boolean isBalanced = Tree.IsTreeBalanced(result);
        Assert.assertTrue(isBalanced);
    }

    @Test
    public void TestCreateLevelledList() {
        TreeNode root = Tree.CreateBalancedTree(values);
        var list = Tree.CreateLevelledListFromTree(root);
        Assert.assertEquals(4, list.size());
    }
}
