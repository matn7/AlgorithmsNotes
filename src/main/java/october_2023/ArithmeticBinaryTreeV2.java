package october_2023;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticBinaryTreeV2 {

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
    }

    @FunctionalInterface
    interface Operator<T> {
        int operate(T a, T b);
    }

    // O(n) time | O(n) space
    public static int calculate(Node node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);

        return evaluate(operators, node);
    }

    private static int evaluate(Map<String, Operator<Integer>> operators, Node node) {
        if (operators.containsKey(node.val)) {
            Operator<Integer> fn = operators.get(node.val);
            return fn.operate(evaluate(operators, node.left), evaluate(operators, node.right));

        } else {
            return Integer.parseInt(node.val);
        }
    }

    private static boolean isLeaf(Node node) {
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
