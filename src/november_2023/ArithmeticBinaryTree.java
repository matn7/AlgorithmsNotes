package november_2023;

import java.util.*;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.right = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        System.out.println(arithmeticBinaryTree(node));
    }

    // O(n) time | O(n) space
    public static int arithmeticBinaryTree(Node node) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> stack = new Stack<>();
        arithmeticBinaryTreeHelper(node, operators, stack);
        return Integer.parseInt(stack.pop());
    }

    private static void arithmeticBinaryTreeHelper(Node node, Set<String> operators, Stack<String> stack) {
        if (isLeaf(node)) {
            stack.add(node.val);
            return;
        }
        arithmeticBinaryTreeHelper(node.left, operators, stack);
        arithmeticBinaryTreeHelper(node.right, operators, stack);
        if (operators.contains(node.val)) {
            Integer b = Integer.parseInt(stack.pop());
            Integer a = Integer.parseInt(stack.pop());
            Integer res = 0;
            if (node.val.equals("+")) {
                res = a + b;
            }
            if (node.val.equals("-")) {
                res = a - b;
            }
            if (node.val.equals("*")) {
                res = a * b;
            }
            if (node.val.equals("/")) {
                res = a / b;
            }
            stack.push(String.valueOf(res));
        } else {
            stack.push(node.val);
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
        }
    }

}
