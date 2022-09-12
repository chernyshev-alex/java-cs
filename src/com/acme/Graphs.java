package com.acme;

import javafx.util.Pair;
import sun.rmi.server.InactiveGroupException;

import java.util.*;

public class Graphs {

    int numOfMinutesDfs(int nodeId, ArrayList<ArrayList<Integer>> empls, int[] informTime) {
        if (empls.get(nodeId).size() == 0) return 0;
        int maxTime = 0;
        for (Integer emplId: empls.get(nodeId)) {
            maxTime = Math.max(maxTime,  numOfMinutesDfs(emplId, empls, informTime));
        }
        return  maxTime + informTime[nodeId];
    }

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        // make adjacent list
        ArrayList<ArrayList<Integer>> empls = new ArrayList(manager.length);
        for (int i = 0; i < manager.length; i++) {
            empls.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                empls.get(manager[i]).add(i);
            }
        }
        return numOfMinutesDfs(headId, empls, informTime);
    }

    public boolean scheduleCourseCanFinish(int numCourses, int[][] prerequisites) {
        int[] in_degree = new int[numCourses];
        for (int[] row : prerequisites) {
            in_degree[row[0]] +=1;

            System.out.println(String.format("pre :%s", Arrays.toString(row)));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                stack.push(i);
            }
        }
        System.out.println(String.format("in_d=%s", Arrays.toString(in_degree)));
        System.out.println(String.format("stack=%s", stack.toString()));

        int count = 0;
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            System.out.println(String.format("pop =%d, stack=%s", idx, stack.toString()));
            count++;
            for (int[] row : prerequisites) {
                if (idx == row[1]) {
                    in_degree[row[0]] -=1;
                    if (in_degree[row[0]] == 0) {
                        stack.push(row[0]);
                    }
                }
                System.out.println(String.format("in_d while=%s", Arrays.toString(in_degree)));
            }
        }
        return count == numCourses;
    }

    public int networkDelayTimeDejkstra(int[][] times, int n, int k) {
        int[] dist = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        ArrayList<Pair<Integer, Integer>>[] adj_list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj_list[i] = new ArrayList<>();
        }
        int from_node = k - 1;
        dist[from_node] = 0;

        minHeap.add(from_node);

        for (int[] t : times) {
            int from = t[0]; int to = t[1]; int w = t[2];
            adj_list[from-1].add(new Pair<Integer, Integer>(to-1, w));
        }
        while (!minHeap.isEmpty()) {
            Integer node = minHeap.poll();
            for (Pair<Integer, Integer> pair : adj_list[node]) {
                int to = pair.getKey();
                int w =  pair.getValue();
                if (dist[node] + w < dist[to]) {
                    dist[to] = dist[node] + w;
                    minHeap.add(to);
                }
            }
        }
        OptionalInt max_element = Arrays.stream(dist).max();
        if (max_element.getAsInt() == Integer.MAX_VALUE) {
            return -1;
        }
        return max_element.getAsInt();
    }

    public int networkDelayTimeBellmanFord(int[][] times, int n, int k) {
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k -1] = 0; // start node
        for (int i = 0; i < n-1; i++) {
            int count = 0;
            for (int[] t : times) {
                int from = t[0]; int to = t[1]; int w = t[2];
                if (dist[from-1]+w < dist[to-1]) {
                    dist[to-1] = dist[from-1] + w;
                    count += 1;
                }
            }
            if (count == 0) {
                break;
            }
        }
        OptionalInt max_element = Arrays.stream(dist).max();
        if (max_element.getAsInt() == Integer.MAX_VALUE) {
            return -1;
        }
        return max_element.getAsInt();
    }
}
