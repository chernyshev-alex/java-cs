package com.acme;

import com.sun.tools.javac.util.ArrayUtils;
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

    // Detect Cycle on graph. Graph can be disjointed !
    //
    // int[] A = new int[] {1,3,2,4 };
    // int[] B = new int[] {4,1,3,2};
    // 1 -> 4

    class G {
        int v;
        List<List<Integer>> ls;

        public G(int v) {
            this.v = v;
            ls = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                ls.add(new LinkedList<>());
            }
        }
        void addEdge(int from, int to) {
            ls.get(from).add(to);
        }
    }

    boolean checkCycleDfs(G g, int i, boolean[] visited,  boolean[] memo) {
        if (memo[i])
            return true;
        if (visited[i])
            return false;

        visited[i] = true;
        memo[i] = true;

        List<Integer> children = g.ls.get(i);
        if (children.size() <=1) return false;
        for (Integer c: children)
            if (checkCycleDfs(g, c, visited, memo))
                return true;
        memo[i] = false;
        return false;
    }

    boolean checkCycle(G g) {
        boolean[] visited = new boolean[g.v];
        boolean[] recStack = new boolean[g.v];
        for (int i = 0; i < g.v; i++) {
            if (checkCycleDfs(g, i, visited, recStack))
                return true;
        }
        return false;
    }

    boolean hasCycle(ArrayList<Integer>[] g, Integer v, boolean[] visited, boolean[] isVisiting) {
        isVisiting[v] = true;
        for (Integer adj_v : g[v]) {
            if (isVisiting[adj_v]) {
                // backward edge exists
                return true;
            } else if (!visited[adj_v] && hasCycle(g, adj_v, visited, isVisiting)) {
                return true;
            }
        }
        isVisiting[v] = false;
        visited[v] = true;
        return false;
    }

    // https://www.baeldung.com/java-graph-has-a-cycle
    // + disjointed
    public boolean detectCycle(int[] A, int[] B) {
        // make adj list
        int sz = A.length +1;
        ArrayList[] g = new ArrayList[sz];
        for (int i = 0; i < A.length; i++) {
            if (g[A[i]] == null) {
                g[A[i]] = new ArrayList<Integer>();
            }
            g[A[i]].add(B[i]);
        }
        // find cycle
        boolean[] visited = new boolean[sz];
        boolean[] isVisiting = new boolean[sz];
        for (int i = 0; i < A.length; i++) {
            if (! visited[A[i]] && hasCycle(g, A[i], visited, isVisiting)) {
                return true;
            }
        }
        return false;
    }

}
