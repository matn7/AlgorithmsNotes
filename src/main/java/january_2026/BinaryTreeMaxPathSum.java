package january_2026;

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

    // O(n) time | O(h) space
    int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = root.val;
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftBranch = Math.max(dfs(node.left), 0);
        int rightBranch = Math.max(dfs(node.right), 0);
        maxPath = Math.max(maxPath, node.val);

        int maxBranch = Math.max(leftBranch, rightBranch);
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
