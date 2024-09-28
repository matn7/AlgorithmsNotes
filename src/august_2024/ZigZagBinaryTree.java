package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<Integer> integers = zigZagOrderTraversal(node);
        System.out.println(integers);
    }

    // O(n) time | O(n) space
    public static List<Integer> zigZagOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        boolean rightToLeft = true;
        Stack<Node> stack = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            result.add(top.value);
            if (rightToLeft) {
                if (top.right != null) {
                    nextLevel.push(top.right);
                }
                if (top.left != null) {
                    nextLevel.push(top.left);
                }
            }
            if (!rightToLeft) {
                if (top.left != null) {
                    nextLevel.push(top.left);
                }
                if (top.right != null) {
                    nextLevel.push(top.right);
                }
            }
            if (stack.size() == 0) {
                rightToLeft = !rightToLeft;
                stack = nextLevel;
                nextLevel = new Stack<>();
            }
        }

        return result;
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
