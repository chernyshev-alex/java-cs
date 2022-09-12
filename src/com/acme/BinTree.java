package com.acme;

import java.util.*;
import java.util.stream.Collectors;

public class BinTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode l , TreeNode  r) {
            this.val = val; this.left = l; this.right =r;
        }
    }

    public static TreeNode makeTreeFrom(Integer[] value) {
        return new BinTree.TreeNode(value[0]);
    }

    int __findMaxTreeDepth(BinTree.TreeNode root, int deep) {
        if (root == null) return  deep;
        return  Math.max(__findMaxTreeDepth(root.left, deep +1) ,
                    __findMaxTreeDepth(root.right, deep + 1));
    }

    int findMaxTreeDepth(BinTree.TreeNode root) {
        return __findMaxTreeDepth(root, 0);
    }

    // Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        do {
            List<TreeNode> currentLevel  = new ArrayList<TreeNode>();
            List<TreeNode> nextLevel  = new ArrayList<TreeNode>();
            while (!q.isEmpty()) {
                TreeNode n = q.pollFirst();
                currentLevel.add(n);
                if (n.left != null) nextLevel.add(n.left);
                if (n.right != null) nextLevel.add(n.right);
            }
            result.add(currentLevel.stream().map(e -> e.val).collect(Collectors.toList()));
            q.addAll(nextLevel);

        } while (!q.isEmpty());
        return result;
    }

    public List<Integer> rightSideViewBfs(TreeNode root) {
        List result =  new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = null;
            // fix len at first !!
            for (int i = 0, len = q.size(); i < len; i++) {
                 n = q.pollFirst();
                 if (n.left != null) q.add(n.left);
                 if (n.right != null) q.add(n.right);
            }
            result.add(n.val);

        }
        return result;
    }

    private List<Integer> __rightSideViewDfs(TreeNode n, int level, ArrayList<Integer> result) {
        if (n == null) return  result;
        if (level >= result.size()) {
            result.add(n.val);
        }
        if (n.right != null) {
            __rightSideViewDfs(n.right, level+1, result);
        }
        if (n.left != null) {
            __rightSideViewDfs(n.left, level+1, result);
        }
        return  result;
    }

    public List<Integer> rightSideViewDfs(TreeNode root) {
        return  __rightSideViewDfs(root, 0, new ArrayList<Integer>());
    }

    // ---
    private boolean __isValidBST(TreeNode n, int min, int max) {
        if (n == null) return true;
        if (n.val <= min || n.val >= max) {
            return false;
        }
        return  __isValidBST(n.left, min, n.val)  && __isValidBST(n.right, n.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return __isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
