package june_2025;

public class MaxPathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum2 maxPathSum2 = new MaxPathSum2();
        int result = maxPathSum2.maxPathSum(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    int maxPath = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return maxPath;
        }
        maxPath = root.val;
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftBranch = Math.max(helper(node.left), 0);
        int rightBranch = Math.max(helper(node.right), 0);

        int maxBranch = Math.max(leftBranch, rightBranch);
        maxPath = Math.max(maxPath, node.val);
        maxPath = Math.max(maxPath, node.val + maxBranch);
        maxPath = Math.max(maxPath, node.val + leftBranch + rightBranch);

        return maxBranch + node.val;
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
