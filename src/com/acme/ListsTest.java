package com.acme;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListsTest {

    @Test
    void testIsListPalindrome() {
        assertEquals(true, new Lists().isListPalindrome(Arrays.asList(1, 2, 2, 1)));
        assertEquals(true, new Lists().isListPalindrome(Arrays.asList(1, 3, 1)));
        assertEquals(false, new Lists().isListPalindrome(Arrays.asList(1, 3, 2, 1)));
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    //Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null
    //Floyd's tortoise & hare algorithm
    //
    @Test
    void testDetectCycle() {
        // 3,2,0,-4 -> 2 (pos =1)
        ListNode n4 = new ListNode(-4, null);
        ListNode n2 = new ListNode(2, new ListNode(0, n4));
        n4.next = n2;

        int  pos = -1;
        ListNode head = new ListNode(3, n2);
        ListNode res = new Lists().detectCycle(head);
        if (res != null) {
            for (pos = 0;  head.val != res.val; head = head.next, pos++);
        }
        assertEquals(1, pos );
    }

    @Test
    void testReverseLinkedList() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode res = new Lists().reverseLinkedList(head);
        List<Integer> result = new ArrayList<Integer>();
        for (ListNode cur = res; cur != null; cur = cur.next) {
            result.add(cur.val);
        }
        assertEquals(Arrays.asList(3,2,1) ,  result );
    }
}
