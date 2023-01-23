package coderpro;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

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
        int result = arithmeticBinaryTree.evaluate2(tree);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int evaluate2(ArithmeticTree node) {
        Map<String, Operator<Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("*", (a, b) -> a * b);

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
