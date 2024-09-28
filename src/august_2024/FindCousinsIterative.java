package august_2024;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindCousinsIterative {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.left.left.left = new Node(9);
        node.left.right.left = new Node(8);
        node.right.right = new Node(5);

        findCousins(node, node.right.right);
    }

    // O(n) time | O(n) space
    public static int findCousins(Node node, Node person) {
        if (node == null) {
            return 0;
        }
        NodeInfo info = findNode(node, person);
        if (info == null) {
            return 0;
        }
        List<Node> cousins = new ArrayList<>();
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(1, node, null));

        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            int depth = current.depth;
            Node parent  = current.parent;
            Node currNode = current.node;
            if (depth > info.depth) {
                continue;
            }
            if (currNode == null) {
                continue;
            }
            if (currNode == info.parent) {
                continue;
            }
            if (depth == info.depth) {
                cousins.add(currNode);
            }
            if (currNode.left != null) {
                stack.push(new NodeInfo(depth + 1, currNode.left, currNode));
            }
            if (currNode.right != null) {
                stack.push(new NodeInfo(depth + 1, currNode.right, currNode));
            }
        }

        return cousins.size();
    }

    private static NodeInfo findNode(Node node, Node person) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(1, node, null));

        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            int depth = current.depth;
            Node currNode = current.node;
            Node parent = current.parent;
            if (currNode == person) {
                return current;
            }
            if (currNode.left != null) {
                stack.push(new NodeInfo(depth + 1, currNode.left, currNode));
            }
            if (currNode.right != null) {
                stack.push(new NodeInfo(depth + 1, currNode.right, currNode));
            }
        }
        return null;
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
        Node node;
        Node parent;

        public NodeInfo(int depth, Node node, Node parent) {
            this.depth = depth;
            this.node = node;
            this.parent = parent;
        }
    }

}
