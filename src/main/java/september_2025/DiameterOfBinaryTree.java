package september_2025;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
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
