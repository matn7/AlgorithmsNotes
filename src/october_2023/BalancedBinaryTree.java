package october_2023;

import java.util.Map;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.right = new Node(5);

        System.out.println(balancedBinaryTree(node));

    }

    // O(n) time | O(n) space
    public static boolean balancedBinaryTree(Node node) {
        return balancedBinaryTreeHelper(node).isBalanced;
    }

    private static NodeInfo balancedBinaryTreeHelper(Node node) {
        if (node == null) {
            return new NodeInfo(true, 0);
        }
        NodeInfo left = balancedBinaryTreeHelper(node.left);
        NodeInfo right = balancedBinaryTreeHelper(node.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new NodeInfo(false, 0);
        }

        if (Math.abs(left.height - right.height) > 1) {
            return new NodeInfo(false, 0);
        }
        int newHeight = Math.max(left.height, right.height) + 1;
        return new NodeInfo(true, newHeight);
    }

    static class NodeInfo {
        boolean isBalanced;
        int height;

        public NodeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
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
