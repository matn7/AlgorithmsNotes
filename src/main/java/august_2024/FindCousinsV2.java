package august_2024;

import java.util.ArrayList;
import java.util.List;

public class FindCousinsV2 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.right = new Node(5);
        node.left.left.left = new Node(9);
        node.left.right.left = new Node(8);

        List<Integer> result = findCousins(node, node.right.right);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> findCousins(Node node, Node cousin) {
        if (node == null) {
            return null;
        }
        NodeInfo info = findNode(node, cousin, null, 1);
        List<Integer> result = new ArrayList<>();
        findCousinsHelper(node, info, 1, result);
        return result;
    }

    private static void findCousinsHelper(Node node, NodeInfo info, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node == info.parent) {
            return;
        }
        if (depth == info.depth) {
            result.add(node.value);
            return;
        }
        findCousinsHelper(node.left, info, depth + 1, result);
        findCousinsHelper(node.right, info, depth + 1, result);
    }

    private static NodeInfo findNode(Node node, Node cousin, Node parent, int depth) {
        if (node == null) {
            return new NodeInfo(0, null);
        }
        if (node == cousin) {
            return new NodeInfo(depth, parent);
        }
        NodeInfo left = findNode(node.left, cousin, node, depth + 1);
        if (left.parent != null) {
            return left;
        }
        return findNode(node.right, cousin, node, depth + 1);
    }

    static class NodeInfo {
        int depth;
        Node parent;

        public NodeInfo(int depth, Node parent) {
            this.depth = depth;
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
