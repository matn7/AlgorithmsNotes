package july_2025;

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

    // Intuition:
    // - DS - binary tree TreeNode
    // - Determine max at each level
    // Approach:
    // - Traversal dfs
    // - Global var for max path
    // - Negative values!
    // - Check overflow?
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    // maxPath: max(pathMax, node.val, node.val + max(node.left, node.right), node.val + node.left + node.right)
    // return maxAsBranch from helper

    int maxPathSum = 0;
    public int maxPathSum(TreeNode root) {
        maxPathSum = root.val;
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftBranch = Math.max(dfs(node.left), 0);
        int rightBranch = Math.max(dfs(node.right), 0);
        int maxBranch = Math.max(leftBranch, rightBranch);
        maxPathSum = Math.max(maxPathSum, node.val);
        maxPathSum = Math.max(maxPathSum, node.val + maxBranch);
        maxPathSum = Math.max(maxPathSum, node.val + leftBranch + rightBranch);
        return node.val + maxBranch;
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
