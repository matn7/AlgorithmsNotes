package january_2024;

import java.util.Stack;

public class DepthOfBinaryTree {

    public static void main(String[] args) {
        Node node = new Node('A');
        node.left = new Node('B');
        node.right = new Node('C');
        node.left.left = new Node('D');
        node.left.left.right = new Node('E');

        int result = depthOfBinaryTree(node);
        System.out.println(result);

        int result2 = depthOfBinaryTree2(node);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int depthOfBinaryTree2(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop();
            Node currNode = pop.node;
            int currDepth = pop.depth;
            maxDepth = Math.max(maxDepth, currDepth);
            if (currNode.left != null) {
                stack.push(new NodeInfo(currNode.left, currDepth + 1));
            }
            if (currNode.right != null) {
                stack.push(new NodeInfo(currNode.right, currDepth + 1));
            }
        }
        return maxDepth;
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
    public static int depthOfBinaryTree(Node node) {
        return depthOfBinaryTreeHelper(node);
    }

    private static int depthOfBinaryTreeHelper(Node node) {
        if (node == null) {
            return 0;
        }

        int left = depthOfBinaryTreeHelper(node.left);
        int right = depthOfBinaryTreeHelper(node.right);

        int newDepth = Math.max(left, right) + 1;

        return newDepth;
    }

    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }

}
