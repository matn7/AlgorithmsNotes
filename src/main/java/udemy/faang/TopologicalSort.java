package udemy.faang;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        int n = 6;
        int[][] prerequisities = {{1,0}, {2,1}, {2,5}, {0,3}, {4,3}, {3,5}, {4,5}};

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.canFinish(n, prerequisities);
    }

    // O(p + n^2) time (p prerequisities) | O(n^2) space
    // n + E
    public boolean canFinish(int n, int[][] prerequisities) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisities.length; i++) {
            int[] pair = prerequisities[i];
            inDegree[pair[0]]++;
            adjList.get(pair[1]).add(pair[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            count++;
            result.add(top);
            List<Integer> prereqs = adjList.get(top);
            for (Integer prereq : prereqs) {
                inDegree[prereq]--;
                if (inDegree[prereq] == 0) {
                    stack.push(prereq);
                }
            }
        }
        return count == n;
    }

}
