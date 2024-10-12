package july_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EvaluateExpressionV2 {

    public static void main(String[] args) {
    }

    public static int evaluateExpression(Node node) {
        Map<Integer, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
        op.put(-1, (a, b) -> a + b);
        op.put(-2, (a, b) -> a - b);
        op.put(-3, (a, b) -> a / b);
        op.put(-4, (a, b) -> a * b);

        return helper(node, op);
    }

    private static int helper(Node node, Map<Integer, BiFunction<Integer, Integer, Integer>> op) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = helper(node.left, op);
        int right = helper(node.right, op);
        BiFunction<Integer, Integer, Integer> fn = op.get(node.value);
        return fn.apply(left, right);
    }

    static final class Node {
        private final int value;
        private final Node left;
        private final Node right;

        public Node(int value) {
            this(value, null, null);
        }

        private Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static final class Node2 {
        private final int value;
        private final Node2 left;
        private final Node2 right;

        // Private constructor to prevent direct instantiation
        private Node2(int value, Node2 left, Node2 right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // Static factory method for creating instances
        public static Node2 of(int value) {
            return new Node2(value, null, null);
        }

        public static Node2 of(int value, Node2 left, Node2 right) {
            return new Node2(value, left, right);
        }

        public int getValue() {
            return value;
        }

        public Node2 getLeft() {
            return left;
        }

        public Node2 getRight() {
            return right;
        }
    }

}
