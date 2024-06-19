package may_2024;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.left.right = new Node(6);
        node.left.left.right.right = new Node(7);

        System.out.println(maxDepth(node));

    }

    // O(n) time | O(n) space
    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
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
