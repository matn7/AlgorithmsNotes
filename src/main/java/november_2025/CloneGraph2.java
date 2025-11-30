package november_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph2 {

    // O(v + e) time | O(v + e) space
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        List<Node> neighbors = node.neighbors;
        for (Node nei : neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

}
