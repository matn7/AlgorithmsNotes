package february_2024;

import java.util.ArrayList;
import java.util.List;

public class FindCousins2 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.right = new Node(5);

        List<Integer> cousins = findCousins(node, node.right.right);
        System.out.println(cousins);
    }

    // O(n) time | O(n) space
    public static List<Integer> findCousins(Node node, Node target) {
        NodeInfo nodeInfo = findNode(node, target, null, 0);
        List<Integer> cousins = new ArrayList<>();

        findCousinsHelper(node, nodeInfo.height, nodeInfo.parent, 0, cousins);

        return cousins;
    }

    private static void findCousinsHelper(Node node, int height, Node parent, int currHeight, List<Integer> res) {
        if (node == null || node == parent) {
            return;
        }
        if (height == currHeight) {
            res.add(node.val);
        }
        findCousinsHelper(node.left, height, parent, currHeight + 1, res);
        findCousinsHelper(node.right, height, parent, currHeight + 1, res);
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
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
