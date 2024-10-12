package october_2023;

import java.util.Stack;

public class InvertABinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);

        Node result = invertIterative(node);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static Node invertIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node top = stack.pop(); // 1
            if (top == null) {
                continue;
            }
            Node temp = top.left;
            top.left = top.right;
            top.right = temp;
            stack.push(top.left);
            stack.push(top.right);
        }

        return node;
    }

    // O(n) time | O(n) space
    public static Node invert(Node node) {
        if (node == null) {
            return null;
        }
        Node left = invert(node.left);
        Node right = invert(node.right);

        node.left = right;
        node.right = left;
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
