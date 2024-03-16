package february_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EvaluateExpression {

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.left = new Node(-2);
        node.left.left = new Node(-4);
        node.left.left.left = new Node(2);
        node.left.left.right = new Node(3);
        node.left.right = new Node(2);
        node.right = new Node(-3);
        node.right.left = new Node(8);
        node.right.right = new Node(2);

        int result = evaluateExpression(node);
        System.out.println(result);

        int result2 = evaluateExpression2(node);
        System.out.println(result2);

        int result3 = evaluateExpression3(node);
        System.out.println(result3);
    }

    @FunctionalInterface
    interface Operation<T> {
        T process(T a, T b);
    }

    // O(n) time | O(n) space
    public static int evaluateExpression(Node node) {
        Map<Integer, Operation<Integer>> operations = new HashMap<>();
        operations.put(-1, (a, b) -> a + b);
        operations.put(-2, (a, b) -> a - b);
        operations.put(-3, (a, b) -> a / b);
        operations.put(-4, (a, b) -> a * b);

        return evaluateExpressionHelper(node, operations);
    }

    private static int evaluateExpressionHelper(Node node, Map<Integer, Operation<Integer>> operations) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = evaluateExpressionHelper(node.left, operations);
        int right = evaluateExpressionHelper(node.right, operations);

        Operation<Integer> fn = operations.get(node.value);
        return fn.process(left, right);
    }

    // O(n) time | O(n) space
    public static int evaluateExpression2(Node node) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = evaluateExpression2(node.left);
        int right = evaluateExpression2(node.right);

        if (node.value == -1) {
            return left + right;
        } else if (node.value == -2) {
            return left - right;
        } else if (node.value == -3) {
            return left / right;
        }
        return left * right;
    }

    // O(n) time | O(n) space
    public static int evaluateExpression3(Node node) {
        Map<Integer, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put(-1, (a, b) -> a + b);
        operations.put(-2, (a, b) -> a - b);
        operations.put(-3, (a, b) -> a / b);
        operations.put(-4, (a, b) -> a * b);

        return evaluateExpression3Helper(node, operations);
    }

    private static int evaluateExpression3Helper(Node node, Map<Integer, BiFunction<Integer, Integer, Integer>> operations) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = evaluateExpression3Helper(node.left, operations);
        int right = evaluateExpression3Helper(node.right, operations);
        BiFunction<Integer, Integer, Integer> fn = operations.get(node.value);
        return fn.apply(left, right);
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
