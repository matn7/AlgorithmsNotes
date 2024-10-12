package udemy.faang;

import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0},
                {3, 8},
                {0, 4, 5, 2},
                {3, 6},
                {3},
                {4, 7},
                {6},
                {2},
                {10},
                {9}
        };

        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.traversalBFS(graph);

        graphTraversal.traversalDFS(graph);
    }

    public List<Integer> traversalBFS(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> seen = new HashMap<>();

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);
            seen.put(vertex, Boolean.TRUE);
            int[] connections = graph[vertex];
            for (int i = 0; i < connections.length; i++) {
                int connection = connections[i];
                if (seen.containsKey(connection)) {
                    continue;
                }
                queue.add(connection);
            }
        }
        return result;
    }

    public List<Integer> traversalDFS(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> seen = new HashMap<>();
        dfs(0, graph, result, seen);
        return result;
    }

    private void dfs(int vertex, int[][] graph, List<Integer> result, Map<Integer, Boolean> seen) {
        result.add(vertex);
        seen.put(vertex, Boolean.TRUE);
        int[] connections = graph[vertex];
        for (int i = 0; i < connections.length; i++) {
            int connection = connections[i];
            if (seen.containsKey(connection)) {
                continue;
            }
            dfs(connection, graph, result, seen);
        }
    }

}
