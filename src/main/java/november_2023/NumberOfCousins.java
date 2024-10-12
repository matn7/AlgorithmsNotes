package november_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfCousins {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(6);
        tree.right.right = new Node(5);

    }

    // O(n) time | O(n) space
    public static List<Node> numberOfCousins(Node node, Node target) {
        NodeInfo info = findNode(node, target, null, 0);
        List<Node> result = new ArrayList<>();
        nodesAtHeight(node, info.height, info.parent, result);
        return result;
    }

    private static void nodesAtHeight(Node node, int height, Node exclude, List<Node> result) {
        if (node == null || node == exclude) {
            return;
        }
        if (height == 0) {
            result.add(node);
        }
        nodesAtHeight(node.left, height - 1, exclude, result);
        nodesAtHeight(node.right, height - 1, exclude, result);
    }

    private static NodeInfo findNode(Node node, Node target, Node parent, int height) {
        if (node == null) {
            return null;
        }
        if (node == target) {
            return new NodeInfo(height, parent);
        }
        NodeInfo left = findNode(node.left, target, node, height + 1);
        if (left != null) {
            return left;
        }
        return findNode(node.right, target, node, height + 1);
    }

    static class NodeInfo {
        int height;
        Node parent;

        public NodeInfo(int height, Node parent) {
            this.height = height;
            this.parent = parent;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
