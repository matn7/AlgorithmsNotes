package august_2025;

import java.util.*;

public class CourseSchedule {

    // O(v + e) time | O(v + e) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            adj.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            adj.get(s).add(d);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (detectCycle(adj, i, visiting, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean detectCycle(Map<Integer, List<Integer>> adj, int node, boolean[] visiting, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        if (visiting[node]) {
            return true;
        }
        visiting[node] = true;

        List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
        for (int nei : neighbors) {
            if (detectCycle(adj, nei, visiting, visited)) {
                return true;
            }
        }

        visiting[node] = false;
        visited[node] = true;
        return false;
    }

}
