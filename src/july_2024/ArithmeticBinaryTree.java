package july_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {

        Node node = new Node("*");
        node.left = new Node("+");
        node.right = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        System.out.println(evaluate(node));
    }

    // LAMBDA - FLASHCARD

    // O(n) time | O(n) space
    public static int evaluate(Node node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        return evaluateHelper(node, operators);
    }

    private static int evaluateHelper(Node node, Map<String, Operator<Integer>> operators) {
        if (operators.containsKey(node.value)) {
            Operator<Integer> function = operators.get(node.value);
            return function.process(evaluateHelper(node.left, operators), evaluateHelper(node.right, operators));
        } else {
            return Integer.parseInt(node.value);
        }
    }

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
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
