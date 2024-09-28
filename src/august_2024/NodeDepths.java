package august_2024;

import java.util.Stack;

public class NodeDepths {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.right.right.right = new Node(8);
        node.right.right.left = new Node(9);


        System.out.println(nodeDepths(node));

        System.out.println(nodeDepthsIter(node));
    }

    // O(n) time | O(n) space
    public static int nodeDepthsIter(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(0, node));

        int count = 0;
        while (!stack.isEmpty()) {
            NodeInfo info = stack.pop();
            Node current = info.node;
            int depth = info.depth;
            if (current == null) {
                continue;
            }
            count += depth;
            stack.push(new NodeInfo(depth + 1, current.left));
            stack.push(new NodeInfo(depth + 1, current.right));
        }
        return count;
    }

    static class NodeInfo {
        int depth;
        Node node;

        public NodeInfo(int depth, Node node) {
            this.depth = depth;
            this.node = node;
        }
    }

    // O(n) time | O(n) space
    public static int nodeDepths(Node node) {
        return helper(node, 0);
    }

    private static int helper(Node node, int count) {
        if (node == null) {
            return 0;
        }
        return count + helper(node.left, count + 1) + helper(node.right, count + 1);
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
