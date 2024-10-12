package october_2024;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        // [[2,4],[1,3],[2,4],[1,3]]
        int[][] edges = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.put(i + 1, new Node(i + 1));
        }
        for (int i = 0; i < edges.length; i++) {
            int sourceIdx = i + 1;
            int neighbor1Idx = edges[i][0];
            int neighbor2Idx = edges[i][1];
            Node source = graph.get(sourceIdx);
            Node neighbor1 = graph.get(neighbor1Idx);
            Node neighbor2 = graph.get(neighbor2Idx);
            source.neighbors = Arrays.asList(neighbor1, neighbor2);
        }

        Node node = graph.get(1);

        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(node);

    }

    // O(v + e) time | O(v + e) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        int startNode = node.val;

        Map<Integer, Node> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        dfs(node, graph, seen);

        return graph.get(startNode);
    }

    private void dfs(Node node, Map<Integer, Node> graph, Set<Integer> seen) {
        if (seen.contains(node.val)) {
            return;
        }
        seen.add(node.val);
        Node newNode = getNode(node, graph);
        List<Node> neighbors = node.neighbors;
        List<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : neighbors) {
            Node neighborNode = getNode(neighbor, graph);
            newNeighbors.add(neighborNode);
            dfs(neighbor, graph, seen);
        }
        newNode.neighbors = newNeighbors;
    }

    private static Node getNode(Node node, Map<Integer, Node> graph) {
        Node newNode;
        if (graph.containsKey(node.val)) {
            newNode = graph.get(node.val);
        } else {
            newNode = new Node(node.val);
            graph.put(node.val, newNode);
        }
        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
