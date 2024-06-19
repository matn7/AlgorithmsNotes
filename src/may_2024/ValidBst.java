package may_2024;

public class ValidBst {

    public static void main(String[] args) {
        Node node = new Node(16);
        node.left = new Node(8);
        node.left.left = new Node(7);
        node.right = new Node(22);
        node.right.left = new Node(19);
        node.right.right = new Node(25);

        System.out.println(validBst(node));
    }

    // O(n) time | O(n) space
    public static boolean validBst(Node node) {
        if (node == null) {
            return true;
        }
        return validBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validBstHelper(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        boolean nodeValid = node.value > min && node.value < max;
        if (!nodeValid) {
            return false;
        }
        boolean left = validBstHelper(node.left, min, node.value);
        boolean right = validBstHelper(node.right, node.value, max);
        return left && right;
    }


    static final class Node {
        final int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
