package july_2024;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticBinaryTreeV3 {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.right = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right.left = new Node("4");
        node.right.right = new Node("5");


        int result = arithmeticBinaryTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int arithmeticBinaryTree(Node node) {
        Map<String, Operation<Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
        return arithmeticBinaryTreeHelper(node, operations);
    }

    private static int arithmeticBinaryTreeHelper(Node node, Map<String, Operation<Integer>> operations) {
        if (operations.containsKey(node.value)) {
            Operation<Integer> fn = operations.get(node.value);
            return fn.process(arithmeticBinaryTreeHelper(node.left, operations),
                    arithmeticBinaryTreeHelper(node.right, operations));
        } else {
            return Integer.parseInt(node.value);
        }
    }

    @FunctionalInterface
    interface Operation<T> {
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
