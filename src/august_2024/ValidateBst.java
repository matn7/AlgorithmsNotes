package august_2024;

public class ValidateBst {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.right.left = new Node(13);
        node.right.right = new Node(22);
        node.left.left.right = new Node(2);
        node.right.left.right = new Node(13);

        boolean result = validateBst(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean validateBst(Node node) {
        if (node == null) {
            return true;
        }
        return helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value >= max) {
            return false;
        }
        boolean left = helper(node.left, min, node.value);
        boolean right = helper(node.right, node.value, max);
        return left && right;
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
