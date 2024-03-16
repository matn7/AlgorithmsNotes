package november_2023;

public class FilterLeavesOfABinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(2);
        node.right = new Node(1);
        node.right.left = new Node(1);

        Node result = filter(node, 2);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static Node filter(Node node, int n) {
        if (node == null) {
            return null;
        }
        node.left = filter(node.left, n);
        node.right = filter(node.right, n);
        if (node.value != n && node.left == null && node.right == null) {
            return null;
        }
        return node;
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
