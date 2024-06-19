package april_2024;

import java.util.Stack;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(12);
        node.right.right = new Node(15);
        node.right.right.left = new Node(18);


        int result = maxDepth(node);
        System.out.println(result);

        int result2 = maxDepth2(node);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int maxDepth2(Node node) {
        if (node == null) {
            return 0;
        }
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(1, node));
        int maxDepth = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            NodeInfo topElement = stack.pop();
            Node currNode = topElement.node;
            int currDepth = topElement.depth;
            maxDepth = Math.max(maxDepth, currDepth);
            if (currNode.left != null) {
                stack.push(new NodeInfo(currDepth + 1, currNode.left));
            }
            if (currNode.right != null) {
                stack.push(new NodeInfo(currDepth + 1, currNode.right));
            }
        }
        return maxDepth;
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
    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
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
