package december_2024;

import java.util.*;

public class CloneGraph2 {

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

        CloneGraph2 cloneGraph = new CloneGraph2();
        Node cloned = cloneGraph.cloneGraph(node);
        System.out.println(cloned);

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> newGraph = new HashMap<>();
        bfs(node, newGraph);

        return newGraph.get(1);
    }

    private void bfs(Node node, Map<Integer, Node> newGraph) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        newGraph.put(node.val, new Node(node.val));
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited.contains(poll.val)) {
                continue;
            }
            List<Node> neighbors = poll.neighbors;
            visited.add(poll.val);
            for (Node neighbor : neighbors) {
                if (!newGraph.containsKey(neighbor.val)) {
                    newGraph.put(neighbor.val, new Node(neighbor.val));
                }
                newGraph.get(poll.val).neighbors.add(newGraph.get(neighbor.val));
                if (!visited.contains(neighbor.val)){
                    queue.add(neighbor);
                }
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
