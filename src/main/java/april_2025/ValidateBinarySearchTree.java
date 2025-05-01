package april_2025;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean result = validateBinarySearchTree.isValidBST(root);
        System.out.println(result);
    }


    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        boolean validNode = node.val > min && node.val < max;

        return validNode && helper(node.left, min, node.val) && helper(node.right, node.val, max);
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
