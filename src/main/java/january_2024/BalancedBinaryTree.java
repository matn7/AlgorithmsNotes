package january_2024;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
//        node.right = new Node(3);
        node.left.left = new Node(4);
//        node.left.left.right = new Node(5);

        boolean result = balancedBinaryTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean balancedBinaryTree(Node node) {
        return balancedBinaryTreeHelper(node).balanced;
    }

    private static NodeInfo balancedBinaryTreeHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, true);
        }
        NodeInfo left = balancedBinaryTreeHelper(node.left);
        NodeInfo right = balancedBinaryTreeHelper(node.right);

        if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1) {
            return new NodeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new NodeInfo(0, false);
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
