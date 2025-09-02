package august_2025;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);
        int currHeight = 1 + Math.max(left, right);

        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) {
            return currHeight;
        }
        return -1;
    }

    static class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
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
