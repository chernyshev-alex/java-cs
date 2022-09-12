package com.acme;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackTasks {

    public boolean IsValidParentheses(String s) {
        if (s.length() == 0) return true;

        Map<Character, Character> goodPairs = new HashMap() {{
            put('(', ')'); put('[', ']'); put('{', '}');
            }};
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (goodPairs.containsKey(c)) {
                stack.push(goodPairs.get(c));
            } else {
                if (stack.isEmpty()) {
                    return  false;
                }
                Character pc = stack.pop();
                if (pc != c) {
                    return  false;
                }
            }
        }
        return  stack.isEmpty();
    }
}
