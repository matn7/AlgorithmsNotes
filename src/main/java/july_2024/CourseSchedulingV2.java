package july_2024;

import java.util.*;

public class CourseSchedulingV2 {

    public static void main(String[] args) {
        int[][] prereqs = {
                {1, 2},
                {1, 3},
                {3, 2},
                {4, 2},
                {4, 3}
        };
    }

    // O(n) time | O(n) space
    public static boolean canFinish(int num, int[][] preseq) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : preseq) {
            if (graph.containsKey(p[0])) {
                List<Integer> curr = graph.get(p[0]);
                curr.add(p[1]);
                graph.put(p[0], curr);
            } else {
                List<Integer> curr = new ArrayList<>();
                curr.add(p[1]);
                graph.put(p[0], curr);
            }
        }
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Boolean> cache = new HashMap<>();
        for (int c = 1; c <= num; c++) {
            if (hasCycle(graph, c, seen, cache)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> seen,
                             Map<Integer, Boolean> cache) {
        if (cache.containsKey(course)) {
            return cache.get(course);
        }
        if (seen.contains(course)) {
            return true;
        }
        if (!graph.containsKey(course)) {
            return false;
        }
        seen.add(course);
        boolean ret = false;
        for (Integer neighbor : graph.get(course)) {
            if (hasCycle(graph, neighbor, seen, cache)) {
                ret = true;
                break;
            }
        }

        seen.remove(course);
        cache.put(course, ret);
        return ret;
    }



}
