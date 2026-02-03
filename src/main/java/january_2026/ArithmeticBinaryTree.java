package january_2026;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ArithmeticBinaryTree {

    // O(n) time | O(n) space
    public int calculate(TreeNode root) {
        Map<String, BiFunction<Integer, Integer, Integer>> operationsMap = new HashMap<>();
        operationsMap.put("+", (a, b) -> a + b);
        operationsMap.put("-", (a, b) -> a - b);
        operationsMap.put("*", (a, b) -> a / b);
        operationsMap.put("/", (a, b) -> a * b);

        return dfs(root, operationsMap);
    }

    private int dfs(TreeNode node, Map<String, BiFunction<Integer, Integer, Integer>> operationsMap) {
        if (node == null) {
            return 0;
        }

        if (!operationsMap.containsKey(node.val)) {
            return Integer.parseInt(node.val);
        }

        int left = dfs(node.left, operationsMap);
        int right = dfs(node.right, operationsMap);

        BiFunction<Integer, Integer, Integer> op = operationsMap.get(node.val);

        if (node.val.equals("/") && right == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return op.apply(left, right);
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
