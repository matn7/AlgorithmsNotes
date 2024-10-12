package october_2024;

public class ValidateBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(1);

        ValidateBst validateBst = new ValidateBst();
        boolean validBST = validateBst.isValidBST(root);
        System.out.println(validBST);
    }

    // O(n) time | O(n) space
    public static boolean isValidBST(TreeNode node) {
        return validBstHelper(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validBstHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check the left and right subtrees
        boolean left = validBstHelper(node.left, min, node.val);
        boolean right = validBstHelper(node.right, node.val, max);

        return left && right;
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
