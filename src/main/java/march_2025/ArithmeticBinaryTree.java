package march_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode("*");
        node.left = new TreeNode("+");
        node.right = new TreeNode("+");
        node.left.left = new TreeNode("3");
        node.left.right = new TreeNode("2");
        node.right.left = new TreeNode("4");
        node.right.right = new TreeNode("5");

        ArithmeticBinaryTree arithmeticBinaryTree = new ArithmeticBinaryTree();
        int result = arithmeticBinaryTree.evaluate(node);
        System.out.println(result);
    }

    public int evaluate(TreeNode node) {
        Map<String, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();
        ops.put("+", (a, b) -> a + b);
        ops.put("-", (a, b) -> a - b);
        ops.put("*", (a, b) -> a * b);
        ops.put("/", (a, b) -> a / b);

        return helper(node, ops);
    }

    private int helper(TreeNode node, Map<String, BiFunction<Integer, Integer, Integer>> ops) {
        if (!ops.containsKey(node.val)) {
            return Integer.parseInt(node.val);
        }
        int left = helper(node.left, ops);
        int right = helper(node.right, ops);
        return ops.get(node.val).apply(left, right);
    }

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

}
