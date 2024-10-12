package november_2023;


import java.util.Stack;

public class DepthOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        int result = depthOfBinaryTreeV2(root);
        System.out.println(result);

        result = depthOfBinaryTree(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int depthOfBinaryTree(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        int depth = 0;
        stack.push(new NodeInfo(1, node));

        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            int currDepth = current.depth;
            Node curNode = current.node;
            depth = Math.max(depth, currDepth);

            if (curNode.left != null) {
                stack.push(new NodeInfo(currDepth + 1, curNode.left));
            }

            if (curNode.right != null) {
                stack.push(new NodeInfo(currDepth + 1, curNode.right));
            }
        }

        return depth;
    }


    // O(n) time | O(n) space
    public static int depthOfBinaryTreeV2(Node node) {
        if (node == null) {
            return 0;
        }
        int left = depthOfBinaryTreeV2(node.left);
        int right = depthOfBinaryTreeV2(node.right);

        return 1 + Math.max(left, right);
    }

    static class NodeInfo {
        int depth;
        Node node;

        public NodeInfo(int depth, Node node) {
            this.depth = depth;
            this.node = node;
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
