package november_2023;

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

        int result = arithmeticBinaryTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int arithmeticBinaryTree(Node node) {
        Map<String, Operate<Integer>> functionMap = new HashMap<>();
        functionMap.put("+", (a, b) -> a + b);
        functionMap.put("-", (a, b) -> a - b);
        functionMap.put("*", (a, b) -> a * b);
        functionMap.put("/", (a, b) -> a / b);

        return arithmeticBinaryTreeHelper(node, functionMap);
    }

    private static int arithmeticBinaryTreeHelper(Node node, Map<String, Operate<Integer>> functionMap) {
        if (functionMap.containsKey(node.val)) {
            Operate<Integer> fn = functionMap.get(node.val);
            return fn.operate(arithmeticBinaryTreeHelper(node.left, functionMap), arithmeticBinaryTreeHelper(node.right, functionMap));
        } else {
            return Integer.parseInt(node.val);
        }
    }

    @FunctionalInterface
    public interface Operate<T> {
        int operate(T a, T b);
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
