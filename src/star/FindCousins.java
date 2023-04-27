package star;

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
        node.left.left.left = new Node(11);
        node.left.left.right = new Node(10);
        node.left.right.right = new Node(9);

        node.right.right = new Node(5);
        node.right.right.left = new Node(7);
        node.right.right.right = new Node(8);

        FindCousins findCousins = new FindCousins();
        findCousins.findCousins(node, node.right);

    }

    // O(n) time | O(n) space
    public List<Node> findCousins(Node tree, Node node) {
        if (tree == null || node == tree) {
            return null;
        }
        List<Node> result = new ArrayList<>();
        boolean foundInLeft = false;
        NodeInfo info = findDepth(tree.left, node);
        if (info.found) {
            foundInLeft = true;
        } else {
            info = findDepth(tree.right, node);
        }
        if (info.depth == 0) {
            return null;
        }
        if (!foundInLeft) {
            getCousins(tree.left, info, result, 0);
        } else {
            getCousins(tree.right, info, result, 0);
        }

        return result;
    }

    private void getCousins(Node node, NodeInfo info, List<Node> result, int depth) {
        if (node == null) {
            return;
        }
        if (depth == info.depth) {
            result.add(node);
            return;
        }
        getCousins(node.left, info, result, depth + 1);
        getCousins(node.right, info, result, depth + 1);
    }

    private NodeInfo findDepth(Node node, Node cousin) {
        if (node == null) {
            return new NodeInfo(0, false);
        }
        if (node == cousin) {
            return new NodeInfo(0, true);
        }

        NodeInfo left = findDepth(node.left, cousin);
        NodeInfo right = findDepth(node.right, cousin);
        int depth = 0;
        boolean found = left.found || right.found;
        if (found) {
            depth = Math.max(left.depth, right.depth) + 1;
        }
        return new NodeInfo(depth, found);
    }

    static class NodeInfo {
        int depth;
        boolean found;

        public NodeInfo(int depth, boolean found) {
            this.depth = depth;
            this.found = found;
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
