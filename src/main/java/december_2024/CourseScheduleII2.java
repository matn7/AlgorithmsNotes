package december_2024;

import java.util.*;

public class CourseScheduleII2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int c = 0; c < numCourses; c++) {
            prereq.put(c, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int crs = p[0];
            int pre = p[1];
            prereq.get(crs).add(pre);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, cycle, visit, prereq, output)) {
                return new int[] {};
            }
        }
        int[] res = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res.length == numCourses ? res : new int[] {};
    }

    private boolean dfs(int crs, Set<Integer> cycle, Set<Integer> visit, Map<Integer, List<Integer>> prereq,
                        List<Integer> output) {
        if (cycle.contains(crs)) {
            return false;
        }
        if (visit.contains(crs)) {
            return true;
        }

        cycle.add(crs);
        List<Integer> prereqs = prereq.get(crs);
        for (int pre : prereqs) {
            if (!dfs(pre, cycle, visit, prereq, output)) {
                return false;
            }
        }
        cycle.remove(crs);
        visit.add(crs);
        output.add(crs);
        return true;
    }

}
