package september_2025;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int result = binaryTreeMaximumPathSum.maxPathSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = {root.val};
        dfs(root, maxPathSum);
        return maxPathSum[0];
    }

    private int dfs(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(dfs(node.left, maxPathSum), 0);
        int right = Math.max(dfs(node.right, maxPathSum), 0);

        maxPathSum[0] = Math.max(maxPathSum[0], node.val);
        int maxAsBranch = node.val + Math.max(left, right);
        maxPathSum[0] = Math.max(maxPathSum[0], maxAsBranch);
        int maxAsBothBranches = node.val + left + right;
        maxPathSum[0] = Math.max(maxPathSum[0], maxAsBothBranches);

        return maxAsBranch;
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
