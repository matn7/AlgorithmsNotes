package august_2025;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][]  prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int numCourses = 2;
        int[][]  prerequisites = {};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);

    }

    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            adj.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            degree[d]++;
        }

        int[] result = new int[numCourses];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return new int[] {};
        }
        int idx = 0;
        while (!list.isEmpty()) {
            int curr = list.poll();
            result[idx] = curr;
            idx++;
            List<Integer> neighbors = adj.getOrDefault(curr, Collections.emptyList());
            for (int nei : neighbors) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    list.add(nei);
                }
            }

        }

        return idx == numCourses ? result : new int[] {};
    }

}
