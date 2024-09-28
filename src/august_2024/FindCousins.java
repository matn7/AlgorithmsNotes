package august_2024;

import java.util.ArrayList;
import java.util.List;

public class FindCousins {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.left.left.left = new Node(9);
        node.left.right.left = new Node(8);
        node.right.right = new Node(5);

        int cousins = findCousins(node, node.right.right);
        System.out.println(cousins);

    }

    // O(n) time | O(n) space
    public static int findCousins(Node node, Node person) {
        if (node == null) {
            return 0;
        }
        NodeInfo info = findNode(node, person, null, 1);
        List<Node> cousins = new ArrayList<>();
        findCousinsHelper(node, info, 1, cousins);

        return cousins.size();
    }

    private static void findCousinsHelper(Node node, NodeInfo info, int depth, List<Node> cousins) {
        if (node == null) {
            return;
        }
        if (node == info.parent) {
            return;
        }
        if (info.depth == depth) {
            cousins.add(node);
            return;
        }
        findCousinsHelper(node.left, info, depth + 1, cousins);
        findCousinsHelper(node.right, info, depth + 1, cousins);
    }

    private static NodeInfo findNode(Node node, Node person, Node parent, int depth) {
        if (node == null) {
            return new NodeInfo(0, null);
        }
        if (node == person) {
            return new NodeInfo(depth, parent);
        }
        NodeInfo left = findNode(node.left, person, node, depth + 1);
        if (left.parent != null) {
            return left;
        }
        return findNode(node.right, person, node, depth + 1);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class NodeInfo {
        int depth;
        Node parent;

        public NodeInfo(int depth, Node parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

}
