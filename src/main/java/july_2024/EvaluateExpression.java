package july_2024;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpression {

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

    // LAMBDA - FLASHCARD

    // O(n) time | O(n) space
    public static int evaluateExpression(Node node) {
        if (node == null) {
            return 0;
        }
        return helper(node);
    }

    private static int helper(Node node) {
        if (node.value > 0) {
            return node.value;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        Operation<Integer> operation = operationsMap.get(node.value);
        return operation.calc(left, right);
    }

    static Map<Integer, Operation<Integer>> operationsMap = new HashMap<>();
    static {
        operationsMap.put(-1, (a, b) -> a + b);
        operationsMap.put(-2, (a, b) -> a - b);
        operationsMap.put(-3, (a, b) -> a / b);
        operationsMap.put(-4, (a, b) -> a * b);
    }

    static final class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

@FunctionalInterface
interface Operation<T> {
    T calc(T a, T b);
}
