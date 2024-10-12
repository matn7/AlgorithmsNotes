package november_2023;

import java.util.Stack;

public class InvertBinaryTreeIterative {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.left.left.left = new Node(8);
        tree.left.left.right = new Node(9);

        Node invert = invert(tree);
        System.out.println(invert);
    }

    // O(n) time | O(n) space
    private static Node invert(Node node) {
        if (node == null) {
            return node;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            Node left = top.left;
            Node right = top.right;
            top.left = right;
            top.right = left;
            if (left != null) {
                stack.push(top.left);
            }
            if (right != null) {
                stack.push(top.right);
            }
        }
        return node;
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
