package march_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EvaluateExpression {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);
        node.left.left = new TreeNode(-4);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(3);
        node.left.left.left = new TreeNode(2);
        node.left.left.right = new TreeNode(3);

        EvaluateExpression evaluateExpression = new EvaluateExpression();
        int evaluate = evaluateExpression.evaluate(node);
        System.out.println(evaluate);
    }

    public int evaluate(TreeNode node) {
        Map<Integer, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put(-1, (a, b) -> a + b);
        operations.put(-2, (a, b) -> a - b);
        operations.put(-3, (a, b) -> a / b);
        operations.put(-4, (a, b) -> a * b);

        return helper(node, operations);
    }

    private int helper(TreeNode node, Map<Integer, BiFunction<Integer, Integer, Integer>> operations) {
        if (node.val > 0) {
            return node.val;
        }
        int left = helper(node.left, operations);
        int right = helper(node.right, operations);
        return operations.get(node.val).apply(left, right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
