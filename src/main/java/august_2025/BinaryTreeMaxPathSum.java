package august_2025;

public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
        int result = binaryTreeMaxPathSum.maxPathSum(root);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    int maxPath = 0;
    public int maxPathSum(TreeNode root) {
        maxPath = root.val;
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int maxBranch = Math.max(left, right);
        maxPath = Math.max(maxPath, node.val);
        maxPath = Math.max(maxPath, node.val + maxBranch);
        maxPath = Math.max(maxPath, node.val + left + right);
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
