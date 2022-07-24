package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleIngGraph2 {

    // O(v + e) time | O(v) space
    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        Map<Integer, Node> nodesMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            nodesMap.put(i, new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            Node currNode = nodesMap.get(i);
            int[] currEdge = edges[i];
            for (int element : currEdge) {
                currNode.addNeighbor(nodesMap.get(element));
            }
        }

        for (int i = 0; i < edges.length; i++) {
            Node currNode = nodesMap.get(i);
            explore(currNode);
            if (currNode.hasCycle) {
                return true;
            }
        }
        return false;
    }

    private void explore(Node currNode) {
        if (currNode.visiting) {
            currNode.hasCycle = true;
            return;
        }
        currNode.visiting = true;
        List<Node> neighbors = currNode.neighbors;
        for (Node neighbor : neighbors) {
            explore(neighbor);
        }
        currNode.visiting = false;
        currNode.visited = true;
    }

    static class Node {
        int id;
        boolean visited;
        boolean visiting;
        boolean hasCycle;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.visited = false;
            this.visiting = false;
            this.hasCycle = false;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
