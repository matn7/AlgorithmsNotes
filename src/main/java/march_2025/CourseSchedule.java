package march_2025;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisities = {{1,0}, {2,1}, {2,5}, {0,3}, {4,3}};

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(numCourses, prerequisities);
        System.out.println(result);

    }

    // O(V + E) time | O(V + E) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];

        for (int n = 0; n < numCourses; n++) {
            adj.put(n, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];
            adj.get(s).add(d);
            degree[d]++;
        }
        Queue<Integer> zeroDeg = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                zeroDeg.add(i);
            }
        }
        int visited = 0;
        while (!zeroDeg.isEmpty()) {
            Integer top = zeroDeg.poll();
            visited++;
            List<Integer> neighbors = adj.get(top);
            for (int nei : neighbors) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        return visited == numCourses;
    }

}
