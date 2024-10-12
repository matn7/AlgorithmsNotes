package problems.other;

import java.util.*;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        ArithmeticTree tree = new ArithmeticTree("*");
        tree.left = new ArithmeticTree("+");
        tree.right = new ArithmeticTree("+");
        tree.left.left = new ArithmeticTree("3");
        tree.left.right = new ArithmeticTree("2");
        tree.right.left = new ArithmeticTree("4");
        tree.right.right = new ArithmeticTree("5");

        ArithmeticBinaryTree arithmeticBinaryTree = new ArithmeticBinaryTree();
        int result1 = arithmeticBinaryTree.evaluate(tree);
        System.out.println(result1);
        int result2 = arithmeticBinaryTree.evaluate2(tree);
        System.out.println(result2);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(n) space
    public int evaluate2(ArithmeticTree node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("*", (a, b) -> a * b);
        operators.put("-", (a, b) -> a - b);
        operators.put("/", (a, b) -> a / b);

        if (operators.containsKey(node.value)) {
            Operator<Integer> fn = operators.get(node.value);
            return fn.process(evaluate2(node.left), evaluate2(node.right));
        } else {
            return Integer.parseInt(node.value);
        }
    }


    // O(n) time | O(n) space
    public int evaluate(ArithmeticTree node) {
        if (node.value.equals("+")) {
            return evaluate(node.left) + evaluate(node.right);
        } else if (node.value.equals("*")) {
            return evaluate(node.left) * evaluate(node.right);
        } else {
            return Integer.parseInt(node.value);
        }
    }

    // =======================
    public int calculate(ArithmeticTree node) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<String> stack = new Stack<>();
        calcHelper(node, operators, stack);
        return Integer.parseInt(stack.pop());
    }

    private void calcHelper(ArithmeticTree node, Set<String> operators, Stack<String> stack) {
        if (isLeaf(node)) {
            stack.add(node.value);
            return;
        }
        calcHelper(node.left, operators, stack);
        calcHelper(node.right, operators, stack);

        if (operators.contains(node.value)) {
            Integer b = Integer.parseInt(stack.pop());
            Integer a = Integer.parseInt(stack.pop());
            if (node.value.equals("+")) {
                int res = a + b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("-")) {
                int res = a - b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("*")) {
                int res = a * b;
                stack.push(String.valueOf(res));
            }
            if (node.value.equals("/")) {
                int res = a / b;
                stack.push(String.valueOf(res));
            }
        } else {
            stack.add(node.value);
        }
    }

    private boolean isLeaf(ArithmeticTree node)
    {
        return node.left == null && node.right == null;
    }

}

@FunctionalInterface
interface Operator<T> {
    T process(T a, T b);
}

class ArithmeticTree {
    String value;
    ArithmeticTree left;
    ArithmeticTree right;

    public ArithmeticTree(String value) {
        this.value = value;
    }
}
