package september_2025;

public class ValidateBinarySearchTree {

    // O(n) time | O(n) space
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left, min, node.val);
        boolean right = dfs(node.right, node.val, max);

        return left && right && node.val > min && node.val < max;
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
