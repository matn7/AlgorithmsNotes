package december_2023;

public class ValidBinarySearchTree {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(2);

        System.out.println(validBst(node));
        System.out.println(validBst2(node));
    }

    // O(n) time | O(n) space
    public static boolean validBst(Node node) {
        return validBstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validBstHelper(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value <= min || node.value > max) {
            return false;
        }
        boolean leftValid = validBstHelper(node.left, min, node.value);
        boolean rightValid = validBstHelper(node.right, node.value, max);
        return leftValid && rightValid;
    }


    // O(n) time | O(n) space
    public static boolean validBst2(Node node) {
        return validBstHelper2(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validBstHelper2(Node node, int low, int high) {
        if (node == null) {
            return true;
        }
        return node.value > low
                && node.value < high
                && validBstHelper2(node.left, low, node.value)
                && validBstHelper2(node.right, node.value, high);
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
