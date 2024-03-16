package january_2024;


import java.util.Stack;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);

        int result = maxDepth(node);
        System.out.println(result);

        int result2 = maxDepth2(node);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int maxDepth2(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop();
            Node poppedNode = pop.node;
            int poppedHeight = pop.height;
            maxDepth = Math.max(maxDepth, poppedHeight);

            if (poppedNode.left != null) {
                stack.push(new NodeInfo(poppedNode.left, poppedHeight + 1));
            }
            if (poppedNode.right != null) {
                stack.push(new NodeInfo(poppedNode.right, poppedHeight + 1));
            }
        }
        return maxDepth;
    }

    static class NodeInfo {
        Node node;
        int height;

        public NodeInfo(Node node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    // O(n) time | O(n) space
    public static int maxDepth(Node node) {
        return maxDepthHelper(node);
    }

    private static int maxDepthHelper(Node node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepthHelper(node.left);
        int right = maxDepthHelper(node.right);

        int newDepth = Math.max(left, right) + 1;
        return newDepth;
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
