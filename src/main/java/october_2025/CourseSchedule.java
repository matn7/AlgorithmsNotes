package october_2025;

import java.util.*;

public class CourseSchedule {

    // O(v + e) time | O(v + e) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int c = 0; c < numCourses; c++) {
            adj.put(c, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];

            adj.get(s).add(d);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (hasCycle(c, adj, visiting, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int c, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(c)) {
            return false;
        }
        if (visiting.contains(c)) {
            return true;
        }

        visiting.add(c);
        List<Integer> neighbors = adj.get(c);
        for (int nei : neighbors) {
            if (hasCycle(nei, adj, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(c);
        visited.add(c);
        return false;
    }

}
