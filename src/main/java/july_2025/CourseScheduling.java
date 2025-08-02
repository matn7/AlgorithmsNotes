package july_2025;

import java.util.*;

public class CourseScheduling {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};

        CourseScheduling courseScheduling = new CourseScheduling();
        boolean result = courseScheduling.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int source = pre[1];
            int dest = pre[0];

            adj.get(source).add(dest);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (!visited.contains(c)) {
                boolean cycle = dfs(adj, c, visiting, visited);
                if (cycle) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int c, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(c)) {
            return false; // no cycle
        }
        if (visiting.contains(c)) {
            return true; // cycle
        }
        visiting.add(c);
        List<Integer> neighbors = adj.get(c);
        for (int nei : neighbors) {
            if (dfs(adj, nei, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(c);
        visited.add(c);
        return false;
    }


}
