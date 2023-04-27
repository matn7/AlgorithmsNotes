package star;

import java.util.*;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right = new Node("+");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        ArithmeticBinaryTree arithmeticBinaryTree = new ArithmeticBinaryTree();
        int result = arithmeticBinaryTree.calculate2(node);
        System.out.println(result);
    }

    @FunctionalInterface
    public interface Operator<T> {
        T operate(T a, T b);
    }

    // O(n) time | O(n) space
    public int calculate2(Node node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        return evaluate(operators, node);
    }

    private int evaluate(Map<String, Operator<Integer>> operators, Node node) {
        if (operators.containsKey(node.val)) {
            Operator<Integer> fn = operators.get(node.val);
            return fn.operate(evaluate(operators, node.left), evaluate(operators, node.right));
        } else {
            return Integer.parseInt(node.val);
        }
    }

    // O(n) time | O(n) space
    public int calculate(Node node) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> stack = new Stack<>();
        calculateHelper(operators, stack, node);
        return Integer.parseInt(stack.pop());
    }

    private void calculateHelper(Set<String> operators, Stack<String> stack, Node node) {
        if (isLeaf(node)) {
            stack.push(node.val);
            return;
        }

        calculateHelper(operators, stack, node.left);
        calculateHelper(operators, stack, node.right);

        if (operators.contains(node.val)) {
            String b = stack.pop();
            String a = stack.pop();
            if (node.val.equals("+")) {
                int res = Integer.parseInt(a) + Integer.parseInt(b);
                stack.push(String.valueOf(res));
            }
            if (node.val.equals("-")) {
                int res = Integer.parseInt(a) - Integer.parseInt(b);
                stack.push(String.valueOf(res));
            }
            if (node.val.equals("*")) {
                int res = Integer.parseInt(a) * Integer.parseInt(b);
                stack.push(String.valueOf(res));
            }
            if (node.val.equals("/")) {
                int res = Integer.parseInt(a) / Integer.parseInt(b);
                stack.push(String.valueOf(res));
            }
        } else {
            stack.add(node.val);
        }

    }

    private boolean isLeaf(Node node) {
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
