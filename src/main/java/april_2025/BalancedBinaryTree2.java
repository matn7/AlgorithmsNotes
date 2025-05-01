package april_2025;

public class BalancedBinaryTree2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BalancedBinaryTree2 balancedBinaryTree2 = new BalancedBinaryTree2();
        boolean balanced = balancedBinaryTree2.isBalanced(root);
        System.out.println(balanced);
    }

    // O(n) time | O(n) space
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1 || (Math.abs(left - right)) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    static class NodeInfo {
        int height;
        boolean isBalanced;

        public NodeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
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
