package november_2023;

import java.util.HashSet;
import java.util.Set;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };

        boolean result = cycleInGraph(graph);
        System.out.println(result);
    }

    // O(v + e) time | O(v) space
    public static boolean cycleInGraph(int[][] edges) {
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            boolean currentNodeCheck = cycleInGraphHelper(edges, i, visiting, visited);
            if (currentNodeCheck) {
                return true;
            }
        }
        return false;
    }

    private static boolean cycleInGraphHelper(int[][] edges, int currentNode, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(currentNode)) {
            return true;
        }
        if (visited.contains(currentNode)) {
            return false;
        }
        visiting.add(currentNode);
        int[] neighbors = edges[currentNode];
        for (int neighbor : neighbors) {
            boolean result = cycleInGraphHelper(edges, neighbor, visiting, visited);
            if (result) {
                return true;
            }
        }

        visited.add(currentNode);
        visiting.remove(currentNode);
        return false;
    }


}
