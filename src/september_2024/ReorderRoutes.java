package september_2024;

import java.util.*;

public class ReorderRoutes {

    // leetcode 1499 doesn't work
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

        ReorderRoutes reorderRoutes = new ReorderRoutes();
        int result = reorderRoutes.minReorder(n, connections);
        System.out.println(result);
    }

    public int minReorder(int n, int[][] connections) {
        Set<int[]> edges = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] connection : connections) {
            edges.add(connection);
            int source = connection[0];
            int destination = connection[1];
            graph.get(source).add(destination);
        }

        int counter = 0;
        for (int city = 0; city < n; city++) {
            if (!visited.contains(city)) {
                counter += dfs(0, graph, visited, edges);
            }
        }
        return counter;
    }

    private int dfs(int city, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<int[]> edges) {
        List<Integer> neighbors = graph.get(city);
        int counter = 0;
        for (int neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            int[] direction = new int[] {neighbor, city};
            if (!edges.contains(direction)) {
                counter++;
            }
            visited.add(neighbor);
            counter += dfs(neighbor, graph, visited, edges);
        }
        return counter;
    }


}
