package november_2025;

import java.util.*;

public class CourseScheduleII {

    // O(v + e) time | O(v + e) space
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int s = pre[0];
            int d = pre[1];
            adj.get(s).add(d);
            degree[d]++;
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, adj, visiting, visited, result)) {
                return new int[] {};
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(a -> a).toArray();
    }

    private boolean cycle(int node, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited,
                          List<Integer> result) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visiting.add(node);
        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (cycle(nei, adj, visiting, visited, result)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        result.add(node);
        return false;
    }

    // O(v + e) time | O(v + e) space
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
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
        if (queue.isEmpty()) {
            return new int[] {};
        }
        int[] result = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            result[idx] = curr;
            idx++;
            List<Integer> neighbors = adj.get(curr);
            for (int nei : neighbors) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    queue.addLast(nei);
                }
            }
        }
        return idx == numCourses ? degree : new int[] {};
    }

}
