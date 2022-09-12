package com.acme;

import com.sun.tools.javac.util.List;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BinTreeTest {
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    //
    @Test
    void testMaxTreeDepth() {
        BinTree.TreeNode root = new BinTree.TreeNode(3,
                    new BinTree.TreeNode(9, null, null),
                    new BinTree.TreeNode(20, new BinTree.TreeNode(15), new BinTree.TreeNode(7)));
        assertEquals(3, new BinTree().findMaxTreeDepth(root));
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    // Given the root of a binary tree, return the level order traversal of its nodes' values.
    // (i.e., from left to right, level by level).
    @Test
    void testLevelOrder() {
        BinTree.TreeNode root = new BinTree.TreeNode(3,
                new BinTree.TreeNode(9, null, null),
                new BinTree.TreeNode(20, new BinTree.TreeNode(15), new BinTree.TreeNode(7)));
        // [[3],[9,20],[15,7]]
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15,7)), new BinTree().levelOrder(root));
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/
    // Given the root of a binary tree, imagine yourself standing on the right side of it,
    // return the values of the nodes you can see ordered from top to bottom.
    // in : [1,2,3,null,5,null,4] out : [1,3,4
    @Test
    void testRightSideViewBfs() {
        BinTree.TreeNode root = new BinTree.TreeNode(1,
                new BinTree.TreeNode(2, null, new BinTree.TreeNode(5)),
                new BinTree.TreeNode(3, null, new BinTree.TreeNode(4)));
        assertEquals(List.of(1,3,4), new BinTree().rightSideViewBfs(root));
    }

    @Test
    void testRightSideViewDfs() {
        BinTree.TreeNode root = new BinTree.TreeNode(1,
                new BinTree.TreeNode(2, null, new BinTree.TreeNode(5)),
                new BinTree.TreeNode(3, null, new BinTree.TreeNode(4)));
        assertEquals(List.of(1,3,4), new BinTree().rightSideViewDfs(root));
    }

    // https://leetcode.com/problems/validate-binary-search-tree/
    // Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    // A valid BST is defined as follows:
    //
    // The left subtree of a node contains only nodes with keys less than the node's key.
    // The right subtree of a node contains only nodes with keys greater than the node's key.
    // Both the left and right subtrees must also be binary search trees.
    //
    @Test
    void testIsValidBST() {
        BinTree.TreeNode root = new BinTree.TreeNode(2,
                new BinTree.TreeNode(1, null,null),
                new BinTree.TreeNode(3, null, null));

        assertEquals(true, new BinTree().isValidBST(root));

        root = new BinTree.TreeNode(5,
                new BinTree.TreeNode(1, null,null),
                new BinTree.TreeNode(4, new BinTree.TreeNode(3), new BinTree.TreeNode(6)));

        assertEquals(false, new BinTree().isValidBST(root));
    }
}