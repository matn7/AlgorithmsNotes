package problems.other;

public class ValidBinarySearchTree {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(2);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        boolean result = validBinarySearchTree.isValidBst(node);
        System.out.println();
    }

    // O(n) time | O(n) space
    public boolean isValidBst(Node root) {
        return isValidBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBstHelper(Node node, int low, int high) {
        if (node == null) {
            return true;
        }
        if (node.value > low && node.value < high && isValidBstHelper(node.left, low, node.value)
                && isValidBstHelper(node.right, node.value, high)) {
            return true;
        }
        return false;
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
