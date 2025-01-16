package november_2024;

public class HashPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        HashPathSum hashPathSum = new HashPathSum();
        boolean result = hashPathSum.hasPathSum(root, targetSum);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, root.val, targetSum);
    }

    private boolean helper(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        int newSum = sum + node.val;
        if (isLeaf(node)) {
            return newSum == targetSum;
        }
        boolean checkLeft = helper(node.left, newSum, targetSum);
        if (checkLeft) {
            return true;
        }
        return helper(node.right, newSum, targetSum);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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

