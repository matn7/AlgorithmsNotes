package november_2023;

public class BalancedBinaryTreeV2 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        boolean result = balancedBinaryTree(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean balancedBinaryTree(Node root) {
        return balancedBinaryTreeHelper(root).balanced;
    }

    private static NodeInfo balancedBinaryTreeHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, true);
        }
        NodeInfo left = balancedBinaryTreeHelper(node.left);
        NodeInfo right = balancedBinaryTreeHelper(node.right);

        if (!left.balanced || !right.balanced) {
            return new NodeInfo(0, false);
        }

        if (Math.abs(left.height - right.height) > 1) {
            return new NodeInfo(0, false);
        }
        int newHeight = Math.max(left.height, right.height) + 1;
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
