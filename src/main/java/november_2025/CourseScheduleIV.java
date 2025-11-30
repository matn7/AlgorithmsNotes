package november_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,1}, {3,2}};
        int[][] queries = {{0,1}, {3,1}};

        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> result = courseScheduleIV.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(result);
    }

    // O(v + e + q) time | O(v + e) space
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
            prereqMap.put(i, new HashSet<>());
        }
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];
            adj.get(s).add(d);
            degree[d]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            List<Integer> neighbors = adj.get(curr);
            for (int nei : neighbors) {
                degree[nei]--;
                prereqMap.get(nei).add(curr);
                prereqMap.get(nei).addAll(prereqMap.get(curr));
                if (degree[nei] == 0) {
                    queue.addLast(nei);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int s = query[0];
            int d = query[1];
            result.add(prereqMap.get(d).contains(s));
        }
        return result;
    }




}
