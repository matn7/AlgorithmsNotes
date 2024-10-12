package july_2024;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ArithmeticBinaryTreeV2 {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.right = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        System.out.println(calculate(node));

    }

    // O(n) time | O(n) space
    public static int calculate(Node node) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> stack = new Stack<>();
        calculateHelper(node, operators, stack);
        return Integer.parseInt(stack.pop());
    }

    private static void calculateHelper(Node node, Set<String> operators, Stack<String> stack) {
        if (isLeaf(node)) {
            stack.add(node.value);
            return;
        }
        calculateHelper(node.left, operators, stack);
        calculateHelper(node.right, operators, stack);

        if (operators.contains(node.value)) {
            Integer b = Integer.parseInt(stack.pop());
            Integer a = Integer.parseInt(stack.pop());
            int res;
            if (node.value.equals("+")) {
                res = a + b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("-")) {
                res = a - b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("*")) {
                res = a * b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("/")) {
                res = a / b;
                stack.push(String.valueOf(res));
            }
        } else {
            stack.add(node.value);
        }

    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

}
