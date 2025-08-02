package july_2025;

public class PathSum {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        PathSum pathSum = new PathSum();
        boolean result = pathSum.hasPathSum(root, 2);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }
        boolean left = false;
        if (node.left != null) {
            left = helper(node.left, sum, targetSum);
        }
        if (left) {
            return true;
        }
        if (node.right != null) {
            return helper(node.right, sum, targetSum);
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
