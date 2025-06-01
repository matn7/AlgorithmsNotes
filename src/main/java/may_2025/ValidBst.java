package may_2025;

public class ValidBst {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(Integer.MAX_VALUE);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        ValidBst validBst = new ValidBst();
        boolean result = validBst.isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, min, node.val);
        boolean right = helper(node.right, node.val, max);

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
