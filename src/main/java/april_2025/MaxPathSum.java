package april_2025;

public class MaxPathSum {

    int res;

    // O(n) time | O(h) space
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.res = root.val;
        dfs(root);
        return this.res;
    }

    // return max path sum without split
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        // compute max path sum with split
        this.res = Math.max(this.res, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
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
