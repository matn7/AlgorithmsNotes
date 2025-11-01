package october_2025;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        int targetSum = 22;

        PathSum pathSum = new PathSum();
        boolean result = pathSum.hasPathSum(root, targetSum);
        System.out.println(result);
    }

    // O(n) time | O(h) space
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
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
