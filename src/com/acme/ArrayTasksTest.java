package com.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTasksTest {
    //
    // https://leetcode.com/problems/two-sum/
    // given array of ints, return indices of the two numbers that add up to a given target
    @Test
    void testTwoSum() {
        int[] result = new ArrayTasks().find2SumIndices(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    //
    // https://leetcode.com/problems/container-with-most-water/
    // You are given an integer array height of length n. There are n vertical lines drawn such that
    // the two endpoints of the ith line are (i, 0) and (i, height[i]).
    // Find two lines that together with the x-axis form a container, such that the container contains the most water.
    // Return the maximum amount of water a container can store.
    //
    @Test
    void testMaxArea() {
        int result = new ArrayTasks().findMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(49, result);
    }

    //
    // https://leetcode.com/problems/trapping-rain-water/
    // Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it can trap after raining.
    //
    @Test
    void testTrappingRainWater() {
        int result = new ArrayTasks().trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, result);
    }
}