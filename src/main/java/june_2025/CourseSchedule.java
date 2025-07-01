package june_2025;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,2}, {0, 1}, {2,0}, {3,1}, {3,2}};

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
            List<Integer> sNode = adj.get(s);
            sNode.add(d);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (!visited.contains(c)) {
                if (cycle(adj, c, visiting, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean cycle(Map<Integer, List<Integer>> adj, int node, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        if (visiting.contains(node)) {
            return true;
        }
        visiting.add(node);

        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (cycle(adj, nei, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
