package may_2024;

import java.util.*;
import java.util.Queue;

public class BfsInGraph {

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

        List<Integer> result = traversalBfs(graph);
        System.out.println(result);
    }

    public static List<Integer> traversalBfs(int[][] graph) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);
            seen.add(vertex);
            int[] neighbors = graph[vertex];

            for (int neighbor : neighbors) {
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }


}
