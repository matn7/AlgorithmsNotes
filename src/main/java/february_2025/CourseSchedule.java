package february_2025;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int n = 6;
//        int[][] prereq = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        int[][] prereq = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(n, prereq);
        System.out.println(result);

    }

    // O(n + p) time | O(n) space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adjList.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, adjList)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(node)) {
            return false;
        }
        if (adjList.get(node).isEmpty()) {
            return true;
        }
        visited.add(node);
        List<Integer> neighbors = adjList.get(node);
        for (int neighbor : neighbors) {
            if (!dfs(neighbor, visited, adjList)) {
                return false;
            }
        }
        visited.remove(node);
        adjList.put(node, new ArrayList<>());
        return true;
    }


}
