package december_2024;

public class MaxPathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
    }

    int res = 0;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    // node without split (as branch)
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMaxAsBranch = dfs(node.left);
        int rightMaxAsBranch = dfs(node.right);
        leftMaxAsBranch = Math.max(leftMaxAsBranch, 0);
        rightMaxAsBranch = Math.max(rightMaxAsBranch, 0);

        // res = value with split
        res = Math.max(res, node.val + leftMaxAsBranch + rightMaxAsBranch);

        return node.val + Math.max(leftMaxAsBranch, rightMaxAsBranch);
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
