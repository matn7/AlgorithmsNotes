package december_2025;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

//        int numCourses = 2;
//        int[][] prerequisites = {};

//        int numCourses = 3;
//        int[][] prerequisites = {{1,0}, {1,2}, {0,1}};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);
    }

    List<Integer> output = new ArrayList<>();
    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];

            adj.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            degree[d]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                dfs(adj, degree, i);
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

//        LinkedList<Integer> zeroDeg = new LinkedList<>();
//        for (int i = 0; i < degree.length; i++) {
//            if (degree[i] == 0) {
//                zeroDeg.add(i);
//            }
//        }
//        if (zeroDeg.isEmpty()) {
//            return new int[] {};
//        }
//        int[] result = new int[numCourses];
//        int idx = 0;
//        while (!zeroDeg.isEmpty()) {
//            int curr = zeroDeg.poll();
//            result[idx] = curr;
//            idx++;
//            List<Integer> neighbors = adj.getOrDefault(curr, Collections.emptyList());
//            for (int nei : neighbors) {
//                degree[nei]--;
//                if (degree[nei] == 0) {
//                    zeroDeg.add(nei);
//                }
//            }
//        }
//        return idx == result.length ? result : new int[] {};
    }

    private void dfs(Map<Integer, List<Integer>> adj, int[] degree, int node) {
        output.add(node);
        List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
        degree[node]--;
        for (int nei : neighbors) {
            degree[nei]--;
            if (degree[nei] == 0) {
                dfs(adj, degree, nei);
            }
        }
    }

}
