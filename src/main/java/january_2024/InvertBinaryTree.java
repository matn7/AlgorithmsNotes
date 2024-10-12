package january_2024;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Node node = new Node('a');
        node.left = new Node('b');
        node.right = new Node('c');
        node.left.left = new Node('d');
        node.left.right = new Node('e');
        node.right.left = new Node('f');

        invert(node);

        System.out.println();
    }

    // O(n) time | O(n) space
    public static Node invert(Node node) {
        invertHelper(node);
        return node;
    }

    private static void invertHelper(Node node) {
        if (node == null) {
            return;
        }
        Node left = invert(node.left);
        Node right = invert(node.right);

        node.left = right;
        node.right = left;
    }

    static class Node {
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }
    }

}
