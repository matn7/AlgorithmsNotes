package january_2026;

public class MaxDepthOfBinaryTree {

    // O(n) time | O(n) space -> O(h) space
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;
        return depth;
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
