package june_2025;

import java.util.*;

public class CourseScheduleII2 {

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int numCourses = 2;
        int[][] prerequisites = {};

        CourseScheduleII2 courseScheduleII2 = new CourseScheduleII2();
        int[] result = courseScheduleII2.findOrder(numCourses, prerequisites);
        System.out.println(result);

    }

    // O(V + E) time | O(V + E) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int d = pre[0];
            int s = pre[1];

            List<Integer> sNode = adj.get(s);
            sNode.add(d);
            degree[d]++;
        }

        List<Integer> zeroDeg = new ArrayList<>();
        for (int i = 0; i < degree.length; i++) {
            int deg = degree[i];
            if (deg == 0) {
                zeroDeg.add(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!zeroDeg.isEmpty()) {
            int course = zeroDeg.remove(0);
            order[index] = course;
            List<Integer> neighbors = adj.get(course);
            for (int nei : neighbors) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroDeg.add(nei);
                }
            }
            index++;
        }
        return index == numCourses ? order : new int[] {};
    }

}
