package com.acme;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.*;

class ListNode {
     int val;
     ListNode next;
    ListNode(int x, ListNode ref) {
        val = x;
        next = ref;
     }
}

public class Lists {

    public boolean isListPalindrome(List<Integer> ls) {
        int offs = ls.size() % 2 == 0 ? 0 : 1;
        int mid = (ls.size() -offs) / 2;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mid; i++) {
            stack.push(ls.get(i));
        }
        for (int i = mid + offs; i < ls.size() ; i++) {
            Integer v = stack.pop();
            if (v != ls.get(i))  {
                return false;
            }
        }
        return stack.isEmpty();
    }

     // ---
    ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tort = head;
        Boolean blFound = false;
        while ( tort != null && hare != null ) {
            tort = tort.next;
            hare = hare.next.next;
            if (tort.val == hare.val) {
                blFound = true;
                break;
            }
        }
        if (blFound) {
            // find a rendezvous node = cycle
            tort = head;
            while (tort.val != hare.val) {
                tort = tort.next;
                hare = hare.next;
            }
            return  tort;
        }
        return null;
    }

    public ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        // 1 -> 2 -> null  => nil <- 1 <- 2
        ListNode l = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return l;
    }

}
