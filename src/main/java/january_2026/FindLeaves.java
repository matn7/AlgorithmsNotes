package january_2026;

import april_2025.FilterLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindLeaves findLeaves = new FindLeaves();
        List<List<Integer>> result = findLeaves.findLeaves(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private int dfs(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }

        int leftHeight = dfs(node.left, result);
        int rightHeight = dfs(node.right, result);

        int height = Math.max(leftHeight, rightHeight) + 1;

        if (result.size() == height) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(node.val);
        return height;
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
