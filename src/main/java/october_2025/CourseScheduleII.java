package october_2025;

import org.mockito.codegen.InjectionBase;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(result);
    }

    // O(v + e) time | o(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];
            prereq.get(s).add(d);
        }
        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, prereq, cycle, visit, output)) {
                return new int[] {};
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int crs, Map<Integer, List<Integer>> prereq, Set<Integer> cycle, Set<Integer> visit, List<Integer> output) {
        if (cycle.contains(crs)) {
            return false;
        }
        if (visit.contains(crs)) {
            return true;
        }
        cycle.add(crs);
        for (int pre : prereq.get(crs)) {
            if (!dfs(pre, prereq, cycle, visit, output)) {
                return false;
            }
        }
        cycle.remove(crs);
        visit.add(crs);
        output.add(crs);
        return true;
    }

    // O(v + e) time | O(v + e) space
    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int s = pre[1];
            int d = pre[0];

            adj.get(s).add(d);
            degree[d]++;
        }

        ArrayDeque<Integer> zeroDeg = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                zeroDeg.addLast(i);
            }
        }
        if (zeroDeg.isEmpty()) {
            return new int[] {};
        }
        int[] result = new int[numCourses];
        int idx = 0;
        while (!zeroDeg.isEmpty()) {
            int elem = zeroDeg.removeFirst();
            result[idx] = elem;
            idx++;
            List<Integer> neighbors = adj.get(elem);
            for (int nei : neighbors) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    zeroDeg.addLast(nei);
                }
            }
        }

        return idx == result.length ? result : new int[] {};
    }

}
