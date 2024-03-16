package october_2023;

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
        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);

        System.out.println(nodeDepthsIterative(node));
    }

    // O(n) time | O(h) space
    public static int nodeDepthsIterative(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, 0));

        int sum = 0;
        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop();
            int depth = pop.depth;
            Node curr = pop.node;
            if (curr.left != null) {
                stack.push(new NodeInfo(curr.left, depth + 1));
            }
            if (curr.right != null) {
                stack.push(new NodeInfo(curr.right, depth + 1));
            }
            sum += depth;
        }

        return sum;
    }

    static class NodeInfo {
        Node node;
        int depth;

        public NodeInfo(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // O(n) time | O(n) space
    public static int nodeDepths(Node node) {
        return nodeDepthsHelper(node, 0);
    }

    public static int nodeDepthsHelper(Node node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + nodeDepthsHelper(node.left, depth + 1) + nodeDepthsHelper(node.right, depth + 1);
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
