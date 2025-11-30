package november_2025;

public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(-7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(11);
        root.left.right.left = new TreeNode(-1);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(-3);

        BinaryTreeMaxPathSum maxPathSum = new BinaryTreeMaxPathSum();
        int result = maxPathSum.maxPathSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
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
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        maxPathSum = Math.max(maxPathSum, node.val);
        int maxBranch = Math.max(left, right);
        maxPathSum = Math.max(maxPathSum, node.val + maxBranch);
        maxPathSum = Math.max(maxPathSum, node.val + left + right);
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
