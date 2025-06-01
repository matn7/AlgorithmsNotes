package may_2025;

public class MaxPathSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum maxPathSum = new MaxPathSum();
        int result = maxPathSum.maxPathSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val;
        int left = Math.max(0, dfs(node.left)); // ignore negative paths
        int right = Math.max(0, dfs(node.right)); // ignore negative paths
        max = Math.max(max, val); // max as node
        int maxBranch = Math.max(val + left, val + right);
        max = Math.max(max, maxBranch); // max as branch
        max = Math.max(max, val + left + right); // max as all
        return maxBranch; // max branch
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
