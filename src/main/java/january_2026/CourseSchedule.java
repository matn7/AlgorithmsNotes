package january_2026;

import java.util.*;

public class CourseSchedule {

    // O(v + e) time | O(v + e) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];

            adj.get(s).add(d);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, adj, visiting, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean cycle(int node, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visiting.add(node);
        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (cycle(nei, adj, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
