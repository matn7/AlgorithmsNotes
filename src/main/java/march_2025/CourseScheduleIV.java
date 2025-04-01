package march_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {
        // numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
        int numCourses = 3;
        int[][] prerequisities = {{1,2},{1,0},{2,0}};
        int[][] queries = {{1,0}, {1,2}};

        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> booleans = courseScheduleIV.checkIfPrerequisite(numCourses, prerequisities, queries);
        System.out.println(booleans);
    }

    // O(V*(V + E) + m) time | O(V^2 + E + m) space
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[numCourses];
        List<Set<Integer>> preSet = new ArrayList<>(numCourses);

        for (int n = 0; n < numCourses; n++) {
            adj.put(n, new ArrayList<>());
            preSet.add(n, new HashSet<>());
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
        while (!zeroDeg.isEmpty()) {
            Integer node = zeroDeg.poll();
            List<Integer> neighbors = adj.get(node);
            for (int nei : neighbors) {
                preSet.get(nei).add(node);
                preSet.get(nei).addAll(preSet.get(node));
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroDeg.add(nei);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(preSet.get(query[1]).contains(query[0]));
        }

        return res;
    }

}
