package april_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prereqs = {{0,1}, {0,2}, {2,1}, {3,1}, {3,2}};
        int num = 4;

//        int[][] prereqs = {{1,0}};
//        int num = 2;

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(num, prereqs);
        System.out.println(result);
    }

    // O(n) time | O(n) space
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
        boolean[] seen = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!seen[i]) {
                boolean cycle = dfs(i, adj, seen, visiting);
                if (cycle) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adj, boolean[] seen, boolean[] visiting) {
        if (visiting[node]) {
            return true;
        }
        if (seen[node]) {
            return false;
        }
        visiting[node] = true;
        List<Integer> neighbors = adj.get(node);

        for (int neighbor : neighbors) {
            boolean cycle = dfs(neighbor, adj, seen, visiting);
            if (cycle) {
                return true;
            }
        }

        visiting[node] = false;
        seen[node] = true;
        return false;
    }


}
