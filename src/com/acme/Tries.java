package com.acme;

import java.util.HashMap;
import java.util.Map;

class Tries {
    TreeNode root = new TreeNode();

    boolean search(String s) {
        boolean found = false;
        TreeNode curr = root;
        for (Character c: s.toCharArray()) {
            TreeNode n = curr.chars.get(c);
            if (curr != null) {
                found = n.isEnd;
                curr = n;
            } else {
                return  false;
            }
        }
        return found;
    }

    boolean startWith(String s) {
        TreeNode curr = root;
        for (Character c: s.toCharArray()) {
            if (!curr.chars.containsKey(c)) {
                return false;
            }
            curr = curr.chars.get(c);
        }
        return true;
    }

    void insert(String s) {
        TreeNode curr = root;
        for (Character c: s.toCharArray()) {
            curr = curr.putIfAbsent(c);
        }
        curr.isEnd = true;
    }

    class TreeNode {
        boolean isEnd = false;
        Map<Character, TreeNode> chars = new HashMap<>();
        TreeNode putIfAbsent(char c)  {
            return chars.computeIfAbsent(c , key -> new TreeNode());
        }
    }
}
