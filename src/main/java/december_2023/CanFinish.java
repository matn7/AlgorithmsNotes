package december_2023;

import java.util.*;

public class CanFinish {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] {{0, 1}}));

        System.out.println(canFinish(2, new int[][] {{0, 1}, {1, 0}}));
    }

    // O(n^2) time | O(n) space
    // O(n) time | O(n) space - with cache
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            if (graph.containsKey(prereq[0])) {
                List<Integer> neighbors = graph.get(prereq[0]);
                neighbors.add(prereq[1]);
                graph.put(prereq[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(prereq[1]);
                graph.put(prereq[0], neighbors);
            }
        }

        Map<Integer, Boolean> cache = new HashMap<>();
        for (int course = 1; course <= numCourses; course++) {
            if (hasCycle(graph, course, new HashSet<>(), cache)) {
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
        List<Integer> neighbors = graph.get(course);
        for (Integer neighbor : neighbors) {
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
