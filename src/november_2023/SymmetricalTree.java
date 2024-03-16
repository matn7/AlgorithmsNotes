package november_2023;

public class SymmetricalTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
        node.right.right = new Node(3);
        node.left.left.left = new Node(5);
        node.left.left.right = new Node(6);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(5);

        boolean result = symmetricalTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean symmetricalTree(Node node) {
        if (node == null) {
            return true;
        }
        Node right = invert(node.right);

        return traverse(node.left, right);
    }

    private static boolean traverse(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        boolean checkLeft = traverse(node1.left, node2.left);
        return checkLeft && traverse(node1.right, node2.right);
    }

    private static Node invert(Node node) {
        if (isLeaf(node)) {
            return node;
        }
        Node left = invert(node.left);
        Node right = invert(node.right);

        node.left = right;
        node.right = left;
        return node;
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
