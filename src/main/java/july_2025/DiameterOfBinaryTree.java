package july_2025;

import java.util.Map;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    // Intuition:
    // - DS binary tree -> TreeNode class
    // - recursion, dfs or bfs -> dfs
    // Approach:
    // - use member variable diameter
    // - keep looking dfs
    // - update diameter = max(diameter, left + right)
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int height = 1 + Math.max(left, right);
        diameter = Math.max(diameter, left + right);
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
