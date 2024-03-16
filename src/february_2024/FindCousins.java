package february_2024;

import java.util.ArrayList;
import java.util.List;

public class FindCousins {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.right = new Node(5);

        List<Integer> result = listCousins(node, node.right.right);
    }

    // O(n) time | O(n) space
    public static List<Integer> listCousins(Node node, Node target) {
        NodeInfo nodeInfo = findNode(node, target, null, 0);
        List<Integer> result = new ArrayList<>();
        nodesAtHeight(node, nodeInfo.parent, nodeInfo.height, result);
        return result;
    }

    private static void nodesAtHeight(Node node, Node exclude, int height, List<Integer> result) {
        if (node == null || node == exclude) {
            return;
        }
        if (height == 0) {
            result.add(node.value);
        }
        nodesAtHeight(node.left, exclude, height - 1, result);
        nodesAtHeight(node.right, exclude, height - 1, result);
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
