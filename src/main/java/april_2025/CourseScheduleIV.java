package april_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {

    }


    // O(n^3) time | O(n) space
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int prereq = pre[0];
            int crs = pre[1];
            adj.get(crs).add(prereq);
        }

        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for (int crs = 0; crs < numCourses; crs++) {
            dfs(crs, prereqMap, adj);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            res.add(prereqMap.get(v).contains(u));
        }
        return res;
    }

    private Set<Integer> dfs(int crs, Map<Integer, Set<Integer>> prereqMap, Map<Integer, List<Integer>> adj) {
        if (!prereqMap.containsKey(crs)) {
            prereqMap.put(crs, new HashSet<>());
            for (int prereq : adj.get(crs)) {
                prereqMap.get(crs).addAll(dfs(prereq, prereqMap, adj));
            }
            prereqMap.get(crs).add(crs);
        }

        return prereqMap.get(crs);
    }

}
