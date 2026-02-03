package january_2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    // O(v + e) time | O(v + e) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> originToNew = new HashMap<>();
        dfs(node, originToNew);
        return originToNew.get(node);
    }

    private Node dfs(Node node, Map<Node, Node> originToNew) {
        if (originToNew.containsKey(node)) {
            return originToNew.get(node);
        }
        Node newNode = new Node(node.val);
        originToNew.put(node, newNode);

        List<Node> neighbors = node.neighbors;
        for (Node nei : neighbors) {
            newNode.neighbors.add(dfs(nei, originToNew));
        }
        return newNode;
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
