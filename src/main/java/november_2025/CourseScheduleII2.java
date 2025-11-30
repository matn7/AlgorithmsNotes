package november_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII2 {


    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

//        int numCourses = 3;
//        int[][] prerequisites = {{1,0}};

//        int numCourses = 2;
//        int[][] prerequisites = {{0, 1}};

        CourseScheduleII2 courseScheduleII2 = new CourseScheduleII2();
        int[] result = courseScheduleII2.findOrder(numCourses, prerequisites);
        System.out.println(result);
    }

    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            adj.get(s).add(d);
            degree[d]++;
        }
        int startNode = -1;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                startNode = i;
                break;
            }
        }
        if (startNode == -1) {
            return new int[] {}; // res not possible.
        }
        List<Integer> res = new ArrayList<>();
        int[] output = new int[numCourses];

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int n = 0; n < numCourses; n++) {
            if (degree[n] == 0) {
                if (cycle(n, adj, degree, res, visiting, visited)) {
                    return new int[] {}; // cannot determine order
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[] {};
        }
        for (int i = 0; i < numCourses; i++) {
            output[i] = res.get(i);
        }

        return output;
    }

    private boolean cycle(int node, Map<Integer, List<Integer>> adj, int[] degree, List<Integer> res, boolean[] visiting, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        if (visiting[node]) {
            return true;
        }
        visiting[node] = true;
        res.add(node);
        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            degree[nei]--;
            if (degree[nei] == 0) {
                if (cycle(nei, adj, degree, res, visiting, visited)) {
                    return true;
                }
            }
        }
        visiting[node] = false;
        visited[node] = true;
        return false;
    }

}
