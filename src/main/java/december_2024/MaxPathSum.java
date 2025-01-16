package december_2024;

public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
    }

    int res = 0;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    // max path sum without split
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        // compute max path with split
        res = Math.max(res, node.val + leftMax + rightMax);

        // compute max path without split
        return node.val + Math.max(leftMax, rightMax);
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
