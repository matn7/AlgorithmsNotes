package october_2024;

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

    public int maxPathSum(TreeNode root) {
        TreeInfo maxPathSum = dfs(root);
        return maxPathSum.maxPathSum;
    }

    private TreeInfo dfs(TreeNode node) {
        if (isLeaf(node)) {
            return new TreeInfo(node.val, node.val);
        }
        TreeInfo left = dfs(node.left);
        TreeInfo right = dfs(node.right);

        int leftBranch = left.maxSumAsBranch;
        int rightBranch = right.maxSumAsBranch;
        int maxLeftRightBranch = Math.max(leftBranch, rightBranch);
        int maxBranchWithNode = maxLeftRightBranch + node.val;

        int leftMaxPathSum = left.maxPathSum;
        int rightMaxPathSum = right.maxPathSum;
        int maxLeftRightPathSum = Math.max(leftMaxPathSum, rightMaxPathSum);

        int maxAsBranch = Math.max(maxLeftRightBranch, maxBranchWithNode);

        int nodeOrBranch = Math.max(maxAsBranch, node.val);
        int nodeAndBranches = node.val + leftBranch + rightBranch;

        int maxPathSum = Math.max(nodeOrBranch, Math.max(nodeAndBranches, maxLeftRightPathSum));
        return new TreeInfo(maxPathSum, maxAsBranch);

    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class TreeInfo {
        int maxPathSum;
        int maxSumAsBranch;

        public TreeInfo(int maxPathSum, int maxSumAsBranch) {
            this.maxPathSum = maxPathSum;
            this.maxSumAsBranch = maxSumAsBranch;
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
