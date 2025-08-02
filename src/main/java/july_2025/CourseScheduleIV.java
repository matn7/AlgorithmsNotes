package july_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[][] queries = {{1,0},{1,2}};

        CourseScheduleIV courseSchedule = new CourseScheduleIV();
        List<Boolean> result = courseSchedule.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Set<Integer>> isPrereq = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
            isPrereq.add(new HashSet<>());
        }
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
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
            int node = zeroDeg.poll();
            List<Integer> neighbors = adj.get(node);
            for (int nei : neighbors) {
                isPrereq.get(nei).add(node);
                isPrereq.get(nei).addAll(isPrereq.get(node));
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroDeg.add(nei);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrereq.get(query[0]).contains(query[1]));
        }
        return result;
    }

}
