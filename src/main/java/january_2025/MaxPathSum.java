package january_2025;

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
        if (root == null) {
            return 0;
        }
        return helper(root)[1];
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int prevMaxPath = Math.max(left[1], right[1]);

        int leftBranch = left[0];
        int rightBranch = right[0];

        int currMaxBranch = Math.max(node.val + Math.max(leftBranch, rightBranch), node.val);
        int currLeftRight = node.val + left[0] + right[0];

        int currMaxPath = Math.max(currMaxBranch, currLeftRight);
        return new int[] {currMaxBranch, Math.max(currMaxPath, prevMaxPath)};
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
