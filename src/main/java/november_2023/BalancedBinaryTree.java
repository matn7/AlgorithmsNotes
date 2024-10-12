package november_2023;

import java.util.Map;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.left.right = new Node(8);

        boolean result = balancedTree(tree);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean balancedTree(Node tree) {
        return balancedTreeHelper(tree).balanced;
    }

    private static NodeInfo balancedTreeHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, true);
        }
        NodeInfo left = balancedTreeHelper(node.left);
        NodeInfo right = balancedTreeHelper(node.right);

        if (!left.balanced || !right.balanced) {
            return new NodeInfo(0, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new NodeInfo(0, false);
        }
        int newHeight = 1 + Math.max(left.height, right.height);
        return new NodeInfo(newHeight, true);
    }

    static class NodeInfo {
        int height;
        boolean balanced;

        public NodeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
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
