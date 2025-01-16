package december_2024;

import java.util.*;

public class CloneGraph3 {

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

        CloneGraph3 cloneGraph = new CloneGraph3();
        Node cloned = cloneGraph.cloneGraph(node);
        System.out.println(cloned);

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
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
