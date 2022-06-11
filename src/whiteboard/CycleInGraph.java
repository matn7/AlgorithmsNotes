package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 3},
                {2, 3, 4},
                {5},
                {},
                {2, 5},
                {}
        };

        CycleInGraph cycleInGraph = new CycleInGraph();
        boolean result = cycleInGraph.cycleInGraph(edges);
        System.out.println();
    }

    // O(v + e) time | O(v) space
    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        Map<Integer, Node> nodesMap = new HashMap<>();
        for (int idx = 0; idx < edges.length; idx++) {
            nodesMap.put(idx, new Node(idx, new ArrayList<>(), false, false, false));
        }

        for (int idx = 0; idx < edges.length; idx++) {
            Node node = nodesMap.get(idx);
            int[] neighbors = edges[idx];
            for (int neighbor : neighbors) {
                node.neighbors.add(nodesMap.get(neighbor));
            }
        }

        for (int idx = 0; idx < edges.length; idx++) {
            Node node = nodesMap.get(idx);
            explore(node);
            if (node.cycleDetected) {
                return true;
            }
        }

        return false;
    }

    private void explore(Node node) {
        if (node.visiting) {
            node.cycleDetected = true;
            return;
        }
        node.visiting = true;
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            explore(neighbor);
        }
        node.visited = true;
        node.visiting = false;
    }

    static class Node {
        int id;
        List<Node> neighbors;
        boolean visited;
        boolean visiting;
        boolean cycleDetected;

        public Node(int id, List<Node> neighbors, boolean visited, boolean visiting, boolean cycleDetected) {
            this.id = id;
            this.neighbors = neighbors;
            this.visited = visited;
            this.visiting = visiting;
            this.cycleDetected = cycleDetected;
        }
    }

}
