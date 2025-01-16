package december_2024;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.neighbors.add(node2);
        node.neighbors.add(node4);
        node2.neighbors.add(node);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        Node cloned = cloneGraph.cloneGraph(node);
        System.out.println(cloned);

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Node> newGraph = new HashMap<>();
        Map<Integer, Node> nodeGraph = new HashMap<>();
        dfs(node, newGraph, nodeGraph, visited);

        for (Map.Entry<Integer, Node> element : nodeGraph.entrySet()) {
            Node originalNode = nodeGraph.get(element.getKey());
            Node newNode = newGraph.get(originalNode.val);
            List<Node> originalNodeNeighbors = originalNode.neighbors;
            for (Node originalNeighbors : originalNodeNeighbors) {
                Node newNodeNeighbor = newGraph.get(originalNeighbors.val);
                newNode.neighbors.add(newNodeNeighbor);
            }
        }

        return newGraph.get(1);
    }

    private void dfs(Node node, Map<Integer, Node> newGraph, Map<Integer, Node> nodeGraph, Set<Integer> visited) {
        if (visited.contains(node.val)) {
            return;
        }
        newGraph.put(node.val, new Node(node.val));
        nodeGraph.put(node.val, node);
        visited.add(node.val);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor.val)) {
                dfs(neighbor, newGraph, nodeGraph, visited);
            }
        }
    }


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
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
