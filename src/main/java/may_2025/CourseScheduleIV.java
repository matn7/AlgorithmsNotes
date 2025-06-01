package may_2025;

import java.util.*;

public class CourseScheduleIV {

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1,2},{1,0},{2,0}};
        int[][] queries = {{1,0},{1,2}};
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> booleans = courseScheduleIV.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(booleans);
    }

    Map<Integer, List<Integer>> adj;
    Map<Integer, Set<Integer>> prereqsMap;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new HashMap<>();
        prereqsMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        for (int crs = 0; crs < numCourses; crs++) {
            dfs(crs);
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            res.add(prereqsMap.get(query[1]).contains(query[0]));
        }
        return res;
    }

    private Set<Integer> dfs(int crs) {
        if (prereqsMap.containsKey(crs)) {
            return prereqsMap.get(crs);
        }
        Set<Integer> prereqs = new HashSet<>();
        List<Integer> neighbors = adj.get(crs);
        for (Integer nei : neighbors) {
            prereqs.addAll(dfs(nei));
        }
        prereqs.add(crs);
        prereqsMap.put(crs, prereqs);
        return prereqs;
    }

}
