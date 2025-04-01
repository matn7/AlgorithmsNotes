package march_2025;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.isBalanced(root);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // balanced 1 - yes, 0 - no --> height
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1 || right == 1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
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
