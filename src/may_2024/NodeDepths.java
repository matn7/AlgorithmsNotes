package may_2024;

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

        int result = nodeDepths(node);
        System.out.println(result);

        int result1 = nodeDepthsIter(node);
        System.out.println(result1);
    }

    // O(n) time | O(h) space
    public static int nodeDepthsIter(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, 0));
        int sum = 0;

        while (!stack.isEmpty()) {
            NodeInfo top = stack.pop();
            int depth = top.depth;
            Node topNode = top.node;
            sum += depth;
            if (topNode.left != null) {
                stack.push(new NodeInfo(topNode.left, depth + 1));
            }
            if (topNode.right != null) {
                stack.push(new NodeInfo(topNode.right, depth + 1));
            }
        }

        return sum;
    }

    // O(n) time | O(n) space
    public static int nodeDepths(Node node) {
        if (node == null) {
            return 0;
        }
        return nodeDepthsHelper(node, 0);
    }

    private static int nodeDepthsHelper(Node node, int count) {
        if (isLeaf(node)) {
            return count;
        }
        int newCount = count + 1;
        return count + nodeDepthsHelper(node.left, newCount) + nodeDepthsHelper(node.right, newCount);
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
