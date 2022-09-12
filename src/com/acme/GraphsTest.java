package com.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphsTest {
    // https://leetcode.com/problems/time-needed-to-inform-all-employees/

    @Test
    void testNumOfMinutes() {
        assertEquals(1, new Graphs().numOfMinutes(6, 2,
                new int[]{2, 2, -1, 2, 2, 2} , new int[]{0, 0, 1, 0, 0, 0}));
    }

    // Topological sort =========

    // Course Schedule
    // https://leetcode.com/problems/course-schedule/
    //
    // There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    // You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
    // that you must take course bi first if you want to take course ai.
    //
    // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    // Return true if you can finish all courses. Otherwise, return false.
    //
    @Test
    void testCourseSchedule() {
      //assertEquals(true, new Graphs().scheduleCourseCanFinish(2, new int[][]{{1,0}}));
//      assertEquals(false, new Graphs().scheduleCourseCanFinish(2, new int[][]{{1, 0}, {0, 2}}));
        assertEquals(true, new Graphs().scheduleCourseCanFinish(
                6,
                new int[][]{{0, 1}, {0, 2},{0, 3},{0, 4},{4, 5}}));
    }

    // Network Delay Time
    // https://leetcode.com/problems/network-delay-time/
    // You are given a network of n nodes, labeled from 1 to n.
    // You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
    // vi is the target node, and wi is the time it takes for a signal to travel from source to target.
    // We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
    // If it is impossible for all the n nodes to receive the signal, return -1.
    //
    // !! Only for positive Weights, No cycles !!
    @Test
    void testNetworkDelayTimeDejkstra() {
        assertEquals(2, new Graphs().networkDelayTimeDejkstra(
                new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
                4,2 ));
    }

    // !! Weights can be negative & positive
    @Test
    void testNetworkDelayTimeBellmanFord() {
        assertEquals(2, new Graphs().networkDelayTimeBellmanFord(
                new int[][]{{1, 4, 2}, {1, 2, 9}, {4, 2, -4}, {2, 5, -3}, {4, 5, 6}, {3, 2, 3}, {5, 3, 7}, {3, 1, 5}},
                5,1 ));
    }
}