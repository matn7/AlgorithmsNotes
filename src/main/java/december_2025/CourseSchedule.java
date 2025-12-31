package december_2025;

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

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, adj, visiting, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean cycle(int course, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(course)) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }

        visiting.add(course);
        List<Integer> neighbors = adj.get(course);
        for (int nei : neighbors) {
            if (cycle(nei, adj, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);
        return false;
    }

}
