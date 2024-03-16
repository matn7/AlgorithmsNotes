package february_2024;

import java.util.HashMap;
import java.util.Map;

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

    @FunctionalInterface
    public interface Operate<T> {
        T operate(T a, T b);
    }

    // O(n) time | O(n) space
    public static int evaluate(Node node) {
        Map<String, Operate<Integer>> operators = new HashMap<>();
        operators.put("+", (a,b) -> a + b);
        operators.put("-", (a,b) -> a - b);
        operators.put("*", (a,b) -> a * b);
        operators.put("/", (a,b) -> a / b);

        return evaluateHelper(node, operators);
    }

    private static int evaluateHelper(Node node, Map<String, Operate<Integer>> operators) {
        if (operators.containsKey(node.value)) {
            Operate<Integer> fn = operators.get(node.value);
            return fn.operate(evaluateHelper(node.left, operators), evaluateHelper(node.right, operators));
        } else {
            return Integer.valueOf(node.value);
        }
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
