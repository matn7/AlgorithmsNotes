package july_2025;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            adj.get(s).add(d);
            deg[d]++;
        }
        Queue<Integer> zeroDeg = new LinkedList<>();
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) {
                zeroDeg.add(i);
            }
        }
        int[] result = new int[numCourses];
        int idx = 0;
        while (!zeroDeg.isEmpty()) {
            int curr = zeroDeg.poll();
            result[idx] = curr;
            idx++;
            List<Integer> neighbors = adj.get(curr);
            for (int nei : neighbors) {
                deg[nei]--;
                if (deg[nei] == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        return idx == numCourses ? result : new int[] {};
    }

}
