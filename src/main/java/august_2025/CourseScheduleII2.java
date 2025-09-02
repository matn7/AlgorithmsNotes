package august_2025;

import java.util.*;

public class CourseScheduleII2 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][]  prerequisites = {{1,0},{2,0},{3,1},{3,2}};

//        int numCourses = 2;
//        int[][]  prerequisites = {};

        CourseScheduleII2 courseScheduleII = new CourseScheduleII2();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);

    }

    Map<Integer, List<Integer>> adj;
    List<Integer> output;
    int[] degree;

    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        output = new ArrayList<>();
        degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            adj.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            degree[d]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                dfs(i);
            }
        }

        if (output.size() != numCourses) {
            return new int[] {};
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private void dfs(int node) {
        output.add(node);
        degree[node]--;
        List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
        for (int nei : neighbors) {
            degree[nei]--;
            if (degree[nei] == 0) {
                dfs(nei);
            }
        }
    }

}
