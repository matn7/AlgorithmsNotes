package june_2025;

import java.util.*;

public class CloneGraph2 {

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

        CloneGraph2 cloneGraph2 = new CloneGraph2();
        Node node = cloneGraph2.cloneGraph(node1);
        System.out.println(node);
    }

    // O(V + E) time | O(V) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> origToNew = new HashMap<>();

        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (!origToNew.containsKey(curr)) {
                origToNew.put(curr, new Node(curr.val));
            }
            if (visited.contains(curr.val)) {
                continue;
            }
            visited.add(curr.val);
            List<Node> neighbors = curr.neighbors;

            Node newCurr = origToNew.get(curr);
            for (Node neighbor : neighbors) {
                if (!origToNew.containsKey(neighbor)) {
                    origToNew.put(neighbor, new Node(neighbor.val));
                }
                newCurr.neighbors.add(origToNew.get(neighbor));
                if (!visited.contains(neighbor.val)) {
                    queue.add(neighbor);
                }
            }
        }
        return origToNew.get(node);
    }

    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

}
