package december_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};

        canFinish(prerequisites);
    }

    public static List<Integer> canFinish(int[][] prerequisites) {
        Map<Integer, Node> nodesGraph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            nodesGraph.put(i + 1, new Node(i + 1));
        }
        for (int[] pre : prerequisites) {
            int source = pre[0];
            int dest = pre[1];
            Node sourceNode = nodesGraph.get(source);
            Node destinationNode = nodesGraph.get(dest);
            sourceNode.addNeighbors(destinationNode);
            destinationNode.deg++;
        }
        List<Node> zeroDegNodes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Node> element : nodesGraph.entrySet()) {
            if (element.getValue().deg == 0) {
                zeroDegNodes.add(element.getValue());
            }
        }

        while (!zeroDegNodes.isEmpty()) {
            Node removed = zeroDegNodes.remove(0);
            result.add(removed.id);
            List<Node> neighbors = removed.neighbors;
            for (Node neighbor : neighbors) {
                neighbor.deg--;
                if (neighbor.deg == 0) {
                    zeroDegNodes.add(neighbor);
                }
            }
        }

        return result;
    }


    static class Node {
        int id;
        int deg;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Node n) {
            neighbors.add(n);
        }

    }

}
