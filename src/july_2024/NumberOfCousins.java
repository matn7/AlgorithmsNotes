package july_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfCousins {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.left.left.left = new Node(9);
        node.left.right.left = new Node(8);
        node.right.right = new Node(5);

        numberOfCousins(node, node.right.right);
        numberOfCousinsIter(node, node.right.right);
    }

    // O(n) time | O(n) space
    public static int numberOfCousinsIter(Node node, Node person) {
        NodeInfo info = findNode(node, person, 1);
        List<Node> cousins = new ArrayList<>();
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, 0));
        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            Node currNode = current.node;
            int depth = current.depth;
            if (depth > info.depth) {
                continue;
            }
            if (currNode == info.node) {
                continue;
            }
            if (depth == info.depth) {
                cousins.add(currNode);
            }
            if (currNode.left != null) {
                stack.push(new NodeInfo(currNode.left, depth + 1));
            }
            if (currNode.right != null) {
                stack.push(new NodeInfo(currNode.right, depth + 1));
            }
        }

        return cousins.size();
    }

    // O(n) time | O(n) space
    public static int numberOfCousins(Node node, Node person) {
        NodeInfo info = findNode(node, person, 1);
        List<Node> cousins = new ArrayList<>();
        findCousins(node, info, 0, cousins);

        return cousins.size();
    }

    private static void findCousins(Node node, NodeInfo info, int depth, List<Node> cousins) {
        if (node == info.node) {
            return;
        }
        if (depth > info.depth) {
            return;
        }
        if (info.depth == depth) {
            cousins.add(node);
        }
        findCousins(node.left, info, depth + 1, cousins);
        findCousins(node.right, info, depth + 1, cousins);
    }

    private static NodeInfo findNode(Node node, Node person, int depth) {
        if (node == null) {
            return null;
        }
        if (node.left == person) {
            return new NodeInfo(node, depth);
        }
        if (node.right == person) {
            return new NodeInfo(node, depth);
        }
        NodeInfo searchLeft = findNode(node.left, person, depth + 1);
        if (searchLeft != null) {
            return searchLeft;
        }
        return findNode(node.right, person, depth + 1);
    }

    static class NodeInfo {
        Node node;
        int depth;

        public NodeInfo(Node node, int depth) {
            this.node = node;
            this.depth = depth;
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
