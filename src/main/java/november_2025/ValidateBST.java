package november_2025;

public class ValidateBST {

    // O(n) time | O(n) space
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, min, node.val);
        boolean right = helper(node.right, node.val, max);

        if (left && right && min < node.val && max > node.val) {
            return true;
        }
        return false;
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
