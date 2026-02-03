package january_2026;

public class CountUnivalSubtrees {

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if (!left || !right) {
            return false;
        }

        if ((node.left != null && node.val != node.left.val) || (node.right != null && node.val != node.right.val)) {
            return false;
        }

        count++;
        return true;
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
