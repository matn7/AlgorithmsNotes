package may_2025;

public class IsBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        IsBalanced balanced = new IsBalanced();
        boolean result = balanced.isBalanced(root);
        System.out.println(result);
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        return -1;
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
