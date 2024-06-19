package may_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsInGraph {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},         // 0
                {0},            // 1
                {3, 8},         // 2
                {0, 4, 5, 2},   // 3
                {3, 6},         // 4
                {3},            // 5
                {4, 7},         // 6
                {6},            // 7
                {2}             // 8
        };

        List<Integer> result = traversalDfs(graph);
        System.out.println(result);
    }

    public static List<Integer> traversalDfs(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfs(0, graph, seen, result);
        return result;
    }

    private static void dfs(int vertex, int[][] graph, Set<Integer> seen, List<Integer> result) {
        seen.add(vertex);
        result.add(vertex);
        int[] neighbors = graph[vertex];
        for (int neighbor : neighbors) {
            if (!seen.contains(neighbor)) {
                dfs(neighbor, graph, seen, result);
            }
        }

    }

}
