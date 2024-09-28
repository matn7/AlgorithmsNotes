package july_2024;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionTreeV2 {

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.left = new Node(-2);
        node.right = new Node(-3);
        node.left.left = new Node(-4);
        node.left.right = new Node(2);
        node.right.left = new Node(8);
        node.right.right = new Node(3);
        node.left.left.left = new Node(2);
        node.left.left.right = new Node(3);

        int result = evaluateExpression(node);
        System.out.println(result);
    }

    @FunctionalInterface
    interface Operation<T> {
        T process(T a, T b);
    }

    // O(n) time | O(n) space
    public static int evaluateExpression(Node node) {
        Map<Integer, Operation<Integer>> op = new HashMap<>();
        op.put(-1, (a, b) -> a + b);
        op.put(-2, (a, b) -> a - b);
        op.put(-3, (a, b) -> a / b);
        op.put(-4, (a, b) -> a * b);
        return evaluateHelper(node, op);
    }

    private static int evaluateHelper(Node node, Map<Integer, Operation<Integer>> op) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = evaluateHelper(node.left, op);
        int right = evaluateHelper(node.right, op);
        Operation<Integer> fn = op.get(node.value);
        return fn.process(left, right);
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
