package june_2025;

public class MaxPathSum {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        MaxPathSum maxPathSum = new MaxPathSum();
        int result = maxPathSum.maxPathSum(root);
        System.out.println(result);

    }

    int maxPath;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPath = root.val;
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        int maxBranch = Math.max(left, right);
        maxPath = Math.max(maxPath, node.val);
        maxPath = Math.max(maxPath, node.val + maxBranch);
        maxPath = Math.max(maxPath, node.val + left + right);
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
