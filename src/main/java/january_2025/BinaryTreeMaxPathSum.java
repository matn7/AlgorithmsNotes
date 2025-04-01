package january_2025;

public class BinaryTreeMaxPathSum {

    int res = 0;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        res = Math.max(res, root.val + leftMax + rightMax);
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
