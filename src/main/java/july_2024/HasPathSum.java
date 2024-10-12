package july_2024;

public class HasPathSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(9);
        root.left.left = new Node(15);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(8);
        root.right.left = new Node(11);
        root.right.right = new Node(3);
        root.right.right.right = new Node(2);
        root.right.right.right.right = new Node(15);

        hasPathSum(root, 34);
    }

    // O(n) time | O(n) space
    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        return hasSum(root, sum, 0);
    }

    private static boolean hasSum(Node root, int sum, int curr) {
        curr += root.value;
        if (curr == sum && root.left != null && root.right != null) {
            return true;
        }
        if (root.left != null) {
            if (hasSum(root.left, sum, curr)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasSum(root.right, sum, curr)) {
                return true;
            }
        }
        return false;
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
