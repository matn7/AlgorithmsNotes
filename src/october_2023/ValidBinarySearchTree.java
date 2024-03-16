package october_2023;

public class ValidBinarySearchTree {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(2);

        System.out.println(validBst(node));
    }

    // O(n) time | O(n) space
    public static boolean validBst(Node node) {
        return validBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validBstHelper(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val >= max) {
            return false;
        }
        boolean left = validBstHelper(node.left, min, node.val);
        boolean right = validBstHelper(node.right, node.val, max);
        return left && right;
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
