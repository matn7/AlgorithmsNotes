package june_2025;

import java.util.*;

public class CourseScheduling {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        CourseScheduling courseScheduling = new CourseScheduling();
        boolean result = courseScheduling.canFinish(numCourses, prerequisites);
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
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!seen.contains(i)) {
                if (cycle(i, adj, seen, visiting)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean cycle(int course, Map<Integer, List<Integer>> adj, Set<Integer> seen, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return true;
        }
        if (seen.contains(course)) {
            return false;
        }
        visiting.add(course);

        List<Integer> neighbors = adj.get(course);
        for (Integer neighbor : neighbors) {
            if (cycle(neighbor, adj, seen, visiting)) {
                return true;
            }
        }

        seen.add(course);
        visiting.remove(course);
        return false;
    }

}
