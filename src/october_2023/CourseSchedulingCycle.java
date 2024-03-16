package october_2023;

import java.util.*;

public class CourseSchedulingCycle {

    public static void main(String[] args) {
        int[][] prereqs = {{1,2}, {1,3}, {3,2}, {4,2}, {4,3}};
        int num = 4;

        canFinish(prereqs, num);

    }

    // O(n) time | O(n) space
    public static boolean canFinish(int[][] prereqs, int num) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < prereqs.length; i++) {
            int[] prereq = prereqs[i];
            int source = prereq[0];
            int destination = prereq[1];

            if (graphMap.containsKey(source)) {
                List<Integer> neighbors = graphMap.get(source);
                neighbors.add(destination);
                graphMap.put(source, neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(destination);
                graphMap.put(source, neighbors);
            }
        }

        Set<Integer> seen = new HashSet<>();
        Map<Integer, Boolean> cache = new HashMap<>();

        for (int c = 1; c <= num; c++) {
            if (hasCycle(c, graphMap, seen, cache)) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(int node, Map<Integer, List<Integer>> graphMap, Set<Integer> seen,
                                    Map<Integer, Boolean> cache) {
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        if (seen.contains(node)) {
            return true;
        }
        if (!graphMap.containsKey(node)) {
            return false;
        }
        seen.add(node);
        List<Integer> neighbors = graphMap.get(node);
        boolean ret = false;
        for (Integer neighbor : neighbors) {
            if (hasCycle(neighbor, graphMap, seen, cache)) {
                ret = true;
                break;
            }
        }
        seen.remove(node);
        cache.put(node, ret);
        return ret;
    }

}
