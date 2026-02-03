package january_2026;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        List<List<Integer>> result = verticalOrderTraversal.verticalOrder(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> columnOrder = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int minCol = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int column = current.column;
            columnOrder.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);
            minCol = Math.min(minCol, column);

            if (node.left != null) {
                queue.add(new Pair(node.left, column - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, column + 1));
            }
        }
        for (int i = 0; i < columnOrder.size(); i++) {
            result.add(null);
        }
        for (Map.Entry<Integer, List<Integer>> element : columnOrder.entrySet()) {
            result.set(element.getKey() + Math.abs(minCol), element.getValue());
        }
        return result;
    }

    static class Pair {
        TreeNode node;
        int column;

        public Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
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
