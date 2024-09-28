package july_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ArithmeticBinaryTreeV4 {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.right = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        int result = calculate(node);
        System.out.println(result);

        int result2 = calculateIter(node);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int calculate(Node node) {
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);

        return calculateHelper(node, operations);
    }

    private static int calculateHelper(Node node, Map<String, BiFunction<Integer, Integer, Integer>> operations) {
        if (operations.containsKey(node.value)) {
            BiFunction<Integer, Integer, Integer> fn = operations.get(node.value);
            return fn.apply(calculateHelper(node.left, operations), calculateHelper(node.right, operations));
        }
        return Integer.parseInt(node.value);
    }

    // LAMBDA - FLASHCARD

    // O(n) time | O(n) space
    public static int calculateIter(Node node) {
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
        Stack<String> stack = new Stack<>();
        calculateHelper(node, stack, operations);
        return Integer.parseInt(stack.pop());
    }

    private static void calculateHelper(Node node, Stack<String> stack,
                                       Map<String, BiFunction<Integer, Integer, Integer>> operations) {
        if (isLeaf(node)) {
            stack.push(node.value);
            return;

        }
        calculateHelper(node.left, stack, operations);
        calculateHelper(node.right, stack, operations);
        if (operations.containsKey(node.value)) {
            BiFunction<Integer, Integer, Integer> fn = operations.get(node.value);
            Integer b = Integer.parseInt(stack.pop());
            Integer a = Integer.parseInt(stack.pop());
            Integer result = fn.apply(a, b);
            stack.push(String.valueOf(result));
        } else {
            stack.push(node.value);
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
