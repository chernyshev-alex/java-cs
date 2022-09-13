package com.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchSortTest {

    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    //
    @Test
    void testFindKthLargest() {
        int res = new SearchSort().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, res);
    }

    @Test
    void testFindKthSmallest() {
        int res = new SearchSort().findKthSmallest(new int[]{3, 6, 1, 5, 2, 4}, 2);
        assertEquals(2, res);
    }

    @Test
    void testFindKthSmallestWithStream() {
        int res = new SearchSort().findKthSmallestWithStream(new int[]{3, 6, 1, 5, 2, 4}, 2);
        assertEquals(2, res);
    }

}