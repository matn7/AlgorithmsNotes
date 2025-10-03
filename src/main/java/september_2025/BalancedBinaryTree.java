package september_2025;

public class BalancedBinaryTree {

    // O(n) time | O(n) space
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    // O(n) time | O(n) space
    public boolean isBalanced2(TreeNode root) {
        return helper2(root).balanced;
    }

    private TreeInfo helper2(TreeNode node) {
        if (node == null) {
            return new TreeInfo(0, true);
        }
        TreeInfo left = helper2(node.left);
        TreeInfo right = helper2(node.right);

        int leftHeight = left.height;
        int rightHeight = right.height;

        if (!left.balanced || !right.balanced || Math.abs(leftHeight - rightHeight) > 1) {
            return new TreeInfo(0, false);
        }
        int height = Math.max(leftHeight, rightHeight) + 1;
        return new TreeInfo(height, true);
    }

    static class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
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
