package december_2023;

import java.util.*;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        Node node = new Node("*");
        node.left = new Node("+");
        node.left.left = new Node("3");
        node.left.right = new Node("2");
        node.right = new Node("+");
        node.right.left = new Node("4");
        node.right.right = new Node("5");

        System.out.println(arithmeticBinaryTree(node));
        System.out.println(arithmeticBinaryTreeV2(node));
    }

    // O(n) time | O(n) space
    public static int arithmeticBinaryTreeV2(Node node) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> stack = new Stack<>();
        calcHelper(node, operators, stack);
        return Integer.parseInt(stack.pop());
    }

    private static void calcHelper(Node node, Set<String> operators, Stack<String> stack) {
        if (isLeaf(node)) {
            stack.add(node.value);
            return;
        }
        calcHelper(node.left, operators, stack);
        calcHelper(node.right, operators, stack);
        if (operators.contains(node.value)) {
            Integer b = Integer.parseInt(stack.pop());
            Integer a = Integer.parseInt(stack.pop());
            int res;
            if (node.value.equals("+")) {
                res = a + b;
            } else if (node.value.equals("-")) {
                res = a - b;
            } else if (node.value.equals("*")) {
                res = a * b;
            } else {
                res = a / b;
            }
            stack.push(String.valueOf(res));
        } else {
            stack.add(node.value);
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // O(n) time | O(n) space
    public static int arithmeticBinaryTree(Node node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a,b) -> a + b);
        operators.put("-", (a,b) -> a - b);
        operators.put("*", (a,b) -> a * b);
        operators.put("/", (a,b) -> a / b);

        return arithmeticBinaryTreeHelper(node, operators);
    }

    private static int arithmeticBinaryTreeHelper(Node node, Map<String, Operator<Integer>> operators) {
        if (operators.containsKey(node.value)) {
            Operator<Integer> fn = operators.get(node.value);
            return fn.process(arithmeticBinaryTreeHelper(node.left, operators),
                    arithmeticBinaryTreeHelper(node.right, operators));
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
