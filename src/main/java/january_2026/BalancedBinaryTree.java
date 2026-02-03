package january_2026;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);

        root.right.right.left.left = new TreeNode(19);


        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.isBalanced(root);
        System.out.println(balanced);
    }

    // O(n) time | O(n) space
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    private TreeInfo helper2(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, 0);
        }
        TreeInfo left = helper2(node.left);
        TreeInfo right = helper2(node.right);

        if (!left.balanced || !right.balanced || Math.abs(left.height - right.height) > 1) {
            return new TreeInfo(false, 0);
        }
        return new TreeInfo(true, Math.max(left.height, right.height) + 1);
    }

    static class TreeInfo {
        boolean balanced;
        int height;

        public TreeInfo(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
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
