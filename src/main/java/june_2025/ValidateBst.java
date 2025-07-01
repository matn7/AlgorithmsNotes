package june_2025;

public class ValidateBst {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);

        TreeNode root = new TreeNode(2147483647);

        ValidateBst validateBst = new ValidateBst();
        boolean result = validateBst.isValidBST(root);
        System.out.println(result);
    }


    // O(n) time | O(n) space
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean left = dfs(node.left, min, node.val);
        boolean right = dfs(node.right, node.val, max);

        return left && right && min < node.val && max > node.val;
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
