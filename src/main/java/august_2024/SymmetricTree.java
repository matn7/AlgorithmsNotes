package august_2024;

public class SymmetricTree {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
        node.right.right = new Node(3);

        boolean result = symmetricTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean symmetricTree(Node node) {
        if (node == null) {
            return true;
        }
        mirror(node.right);

        return inOrderTraversal(node.left, node.right);
    }

    private static boolean inOrderTraversal(Node leftNode, Node rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.value != rightNode.value) {
            return false;
        }
        return inOrderTraversal(leftNode.left, rightNode.left) && inOrderTraversal(leftNode.right, rightNode.right);
    }

    private static Node mirror(Node node) {
        if (isLeaf(node)) {
            return node;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
