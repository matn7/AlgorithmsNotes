package october_2025;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        CloneGraph cloneGraph = new CloneGraph();
        Node result = cloneGraph.cloneGraph(node1);
        System.out.println(result);
    }

    // O(v + e) time | O(v + e) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        dfs(node, oldToNew);
        return oldToNew.get(node);
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

//    // O(v + e) time | O(v + e) space
//    public Node cloneGraph(Node node) {
//        if (node == null) {
//            return null;
//        }
//        Map<Node, Node> origToNewMap = new HashMap<>();
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(node);
//        Set<Integer> visited = new HashSet<>();
//        Set<Integer> newVisited = new HashSet<>();
//
//        while (!queue.isEmpty()) {
//            Node currNode = queue.poll();
//            visited.add(currNode.val);
//            if (!origToNewMap.containsKey(currNode)) {
//                origToNewMap.put(currNode, new Node(currNode.val));
//            }
//            List<Node> currNodeNei = currNode.neighbors;
//            for (Node nei : currNodeNei) {
//                if (!origToNewMap.containsKey(nei)) {
//                    origToNewMap.put(nei, new Node(nei.val));
//                }
//
//                Node newNode = origToNewMap.get(currNode);
//                Node newNodeNei = origToNewMap.get(nei);
//                if (!newNode.neighbors.contains(newNodeNei)) {
//                    newNode.neighbors.add(newNodeNei);
//                }
//                if (!visited.contains(nei.val)) {
//                    queue.add(nei);
//                }
//            }
//        }
//
//        return origToNewMap.get(node);
//    }

}

class Node {
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
