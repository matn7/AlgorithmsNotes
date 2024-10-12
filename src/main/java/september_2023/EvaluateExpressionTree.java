package september_2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateExpressionTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(-1);
        tree.left = new BinaryTree(-2);
        tree.right = new BinaryTree(-3);
        tree.left.left = new BinaryTree(-4);
        tree.left.right = new BinaryTree(2);
        tree.left.left.left = new BinaryTree(2);
        tree.left.left.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(8);
        tree.right.right = new BinaryTree(3);

        EvaluateExpressionTree evaluateExpressionTree = new EvaluateExpressionTree();
        evaluateExpressionTree.evaluateExpressionTree(tree);
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        Map<Integer, Operator<Integer>> operatorsMap = new HashMap<>();
        operatorsMap.put(-1, (a,b) -> a + b);
        operatorsMap.put(-2, (a,b) -> a - b);
        operatorsMap.put(-3, (a,b) -> a / b);
        operatorsMap.put(-4, (a,b) -> a * b);
        return evaluateExpressionTreeHelper(tree, operatorsMap);
    }

    private int evaluateExpressionTreeHelper(BinaryTree node, Map<Integer, Operator<Integer>> operatorsMap) {
        if (isLeaf(node)) {
            return node.value;
        }
        Operator<Integer> fn = operatorsMap.get(node.value);
        int left = evaluateExpressionTreeHelper(node.left, operatorsMap);
        int right = evaluateExpressionTreeHelper(node.right, operatorsMap);

        return fn.process(left, right);
    }


    // O(n) time | O(n) space
    public int evaluateExpressionTree2(BinaryTree tree) {
        // Write your code here.
        Set<Integer> operations = new HashSet<>();
        operations.add(-1);
        operations.add(-2);
        operations.add(-3);
        operations.add(-4);
        return evaluateExpressionTreeHelper2(tree, operations);
    }

    private int evaluateExpressionTreeHelper2(BinaryTree node, Set<Integer> operators) {
        if (isLeaf(node)) {
            return node.value;
        }
        int left = evaluateExpressionTreeHelper2(node.left, operators);
        int right = evaluateExpressionTreeHelper2(node.right, operators);
        int operator = node.value;
        if (operator == -1) {
            return left + right;
        }
        if (operator == -2) {
            return left - right;
        }
        if (operator == -3) {
            return left / right;
        }
        return left * right;
    }

    private boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }

}
