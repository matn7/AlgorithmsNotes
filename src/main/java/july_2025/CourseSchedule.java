package july_2025;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
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

        for (int c = 0; c < numCourses; c++) {
            if (!visited.contains(c)) {
                if (hasCycle(adj, c, visiting, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> adj, int c, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(c)) {
            return true;
        }
        if (visited.contains(c)) {
            return false;
        }
        visiting.add(c);

        List<Integer> neighbors = adj.getOrDefault(c, Collections.emptyList());
        for (int nei : neighbors) {
            if (hasCycle(adj, nei, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(c);
        visited.add(c);
        return false;
    }

}
