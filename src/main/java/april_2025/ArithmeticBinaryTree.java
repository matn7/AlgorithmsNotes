package april_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ArithmeticBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("-");

// Lewa strona: (7 + (3 * 2))
        root.left = new TreeNode("+");
        root.left.left = new TreeNode("7");
        root.left.right = new TreeNode("*");
        root.left.right.left = new TreeNode("3");
        root.left.right.right = new TreeNode("2");

// Prawa strona: ((8 / 4) + 1)
        root.right = new TreeNode("+");
        root.right.left = new TreeNode("/");
        root.right.left.left = new TreeNode("8");
        root.right.left.right = new TreeNode("4");
        root.right.right = new TreeNode("1");

        ArithmeticBinaryTree arithmeticBinaryTree = new ArithmeticBinaryTree();
        int result = arithmeticBinaryTree.calcTree(root);
        System.out.println(result);
    }

    public int calcTree(TreeNode root) {
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);

        return dfs(root, operations);
    }

    private int dfs(TreeNode node, Map<String, BiFunction<Integer, Integer, Integer>> operations) {
        if (node == null) {
            return 0;
        }
        if (!operations.containsKey(node.val)) {
            return Integer.parseInt(node.val);
        }
        int left = dfs(node.left, operations);
        int right = dfs(node.right, operations);

        BiFunction<Integer, Integer, Integer> fn = operations.get(node.val);
        if (node.val.equals("/") && right == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return fn.apply(left, right);
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
