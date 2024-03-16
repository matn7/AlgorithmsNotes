package coderpro;

import java.util.*;

public class CourseSchedule {

    // ********
    // * STAR *
    // ********

    // O(n^2) time | O(n) space
    // with cache
    // O(n) time | O(n) space

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
//        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites = {{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};
        boolean result = courseSchedule.canFinish(4, prerequisites);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            if (graph.containsKey(prereq[0])) {
                List<Integer> currPre = graph.get(prereq[0]);
                currPre.add(prereq[1]);
                graph.put(prereq[0], currPre);
            } else {
                List<Integer> newPre = new ArrayList<>();
                newPre.add(prereq[1]);
                graph.put(prereq[0], newPre);
            }
        }

        Set<Integer> seen = new HashSet<>();
        Map<Integer, Boolean> cache = new HashMap<>();
        for (int course = 1; course <= numCourses; course++) {
            if (hasCycle(graph, course, seen, cache)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> seen, Map<Integer, Boolean> cache) {
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
