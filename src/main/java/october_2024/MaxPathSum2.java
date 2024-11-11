package october_2024;

public class MaxPathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum2 maxPathSum = new MaxPathSum2();
        int result = maxPathSum.maxPathSum(root);
        System.out.println(result);
    }

    int res;

    // O(n) time | O(n) space
    public int maxPathSum(TreeNode root) {
        res = root.val;
        return dfs(root);
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
