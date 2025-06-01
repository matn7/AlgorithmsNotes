package may_2025;

public class MaxPathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum2 maxPathSum2 = new MaxPathSum2();
        int result = maxPathSum2.maxPathSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left, res));
        int right = Math.max(0, dfs(node.right, res));
        res[0] = Math.max(res[0], node.val);
        int maxBranch = Math.max(left, right) + node.val;
        res[0] = Math.max(res[0], maxBranch);
        res[0] = Math.max(res[0], node.val + left + right);
        return maxBranch;
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
